package com.xebia.robotics.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xebia.robotics.interfaces.RobotFunctionality;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
    
	@Autowired
	private RobotFunctionality robotFunctionality;
	
	@Override
    public void run(String... args) throws Exception {
		robotFunctionality.setChargingStatus(14);
    	robotFunctionality.walkDistance(1.5);
        robotFunctionality.carryWeight(5);
        robotFunctionality.carryWeightAndWalk(1,13);
        robotFunctionality.setChargingStatus(70);
        robotFunctionality.carryWeightAndWalk(3,2);
        robotFunctionality.priceDisplay(18);
    }
}