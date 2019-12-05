package com.xebia.robotics.RobotPrototype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xebia.robotics.interfaces.RobotFunctionality;

@SpringBootTest
class RobotPrototypeApplicationTests {

	@Autowired
	RobotFunctionality robotFunctionality;

	@Test
	void testWalkDistanceWithChargingLessThan15(){
		robotFunctionality.setChargingStatus(2);
		boolean actual = robotFunctionality.walkDistance(1.5);
		assertEquals(false, actual);
	}
	
	@Test
	void testWalkDistanceWithChargingGreaterThan15(){
		robotFunctionality.setChargingStatus(70);
		boolean actual = robotFunctionality.walkDistance(1.5);
		assertEquals(true, actual);
	}
	
	@Test
	void testcarryWeight(){
		boolean actual = robotFunctionality.carryWeight(5);
		assertEquals(true, actual);
	}
	
	@Test
	void testcarryWeightAndWalk(){
		boolean actual = robotFunctionality.carryWeightAndWalk(1, 13);
		assertEquals(false, actual);
	}
	

}
