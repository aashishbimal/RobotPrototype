package com.xebia.robotics.pojo;

import com.xebia.robotics.enums.LightColor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RobotPojo {

	private int chargingLeft;
	private LightColor roboLightColor;
	private int loadCapacity;
	private int distanceCapacity;

}