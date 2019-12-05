package com.xebia.robotics.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.robotics.enums.LightColor;
import com.xebia.robotics.interfaces.RobotFunctionality;
import com.xebia.robotics.pojo.RobotPojo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RobotFunctionalityImpl implements RobotFunctionality {
	
	@Autowired
	private RobotPojo robotpojo;
	
	static int availbleCharging;
	
	@Override
	public boolean carryWeight(int weight){
		if(weight > 10){
			log.info("<< Robot is Overweight >>");
			return false;
		}
		return true;
	}
	
	@Override
	public void setChargingStatus(int percentage){
		int currentCharging = robotpojo.getChargingLeft();
		if(currentCharging + percentage > 100)
			robotpojo.setChargingLeft(100);
		else{
			robotpojo.setChargingLeft(currentCharging+percentage);
		}
	}
	
	@Override
	public boolean walkDistance(double km){
	   availbleCharging = robotpojo.getChargingLeft();
	   int requiredCharging = (int)(km*1000/50);
	   if(powerCheck(robotpojo, requiredCharging)){
		   log.info("<< Distance Covered : "+ km+" km :: Power Consumed: "+ requiredCharging +"% :: Power Remaining: "+ robotpojo.getChargingLeft() +" % >>");
		   log.info("<< Robot Light Color "+ robotpojo.getRoboLightColor()+" >>");
		   return true;
	   }
	   return false;
	}

	@Override
	public boolean weight(int weight) {
		if(carryWeight(weight)){
			int requiredCharging = 2*weight;
			availbleCharging = robotpojo.getChargingLeft();
			if(powerCheck(robotpojo, requiredCharging)){
				log.info("<< Weight Loaded: "+ weight+" kg :: Power Consumed: "+ requiredCharging +"% :: Power Remaining: "+ robotpojo.getChargingLeft() +" % >>");
				log.info("<< Robot Light Color "+ robotpojo.getRoboLightColor()+" >>");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean carryWeightAndWalk(double dist, int weight) {
		if(carryWeight(weight)){
			int requiredCharging = (int)(dist*1000/50) + 2*weight ;
			availbleCharging = robotpojo.getChargingLeft();
			if(powerCheck(robotpojo, requiredCharging)){
				log.info("<< Distance Covered : "+ dist + "km and Weight Loaded: "+ weight+" kg :: Power Consumed: "+ requiredCharging +"% :: Power Remaining: "+ robotpojo.getChargingLeft() +"% >>");
				log.info("<< Robot Light Color "+ robotpojo.getRoboLightColor()+" >> ");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void priceDisplay(int barCode){
		if(barCode % 2 == 0){
			log.info("<< Robo Price is : "+ new Random().nextInt(100)+" >>");
		}else{
			log.info("<< Scan Failure For Robo >>");
		}
	}
	
	@Override
	public boolean powerCheck(RobotPojo r, int requiredCharging){
		int availbleCharging = r.getChargingLeft();
		if(availbleCharging < requiredCharging){
			log.info("<< Insufficient Charging For Task to Complete >>");
			return false;
		}else{
			int remaining = availbleCharging - requiredCharging;
			r.setChargingLeft(remaining);
			if(remaining < 15){
				r.setRoboLightColor(LightColor.RED);
			}
			return true;
		}
	}
}