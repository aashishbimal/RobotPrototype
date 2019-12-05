package com.xebia.robotics.interfaces;

import com.xebia.robotics.pojo.RobotPojo;

public interface RobotFunctionality {
	boolean carryWeight(int weight);
	boolean walkDistance (double distance);
	boolean weight(int weight);
	boolean carryWeightAndWalk (double distance, int weight);
	void priceDisplay (int barcode);
	void setChargingStatus(int percentage);
	boolean powerCheck(RobotPojo r, int requiredCharging);
}
