package com.xebia.robotics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.xebia.robotics.enums.LightColor;
import com.xebia.robotics.pojo.RobotPojo;

@Configuration
@ComponentScan
public class BeanConfiguration {

	@Bean
	public RobotPojo robotPojo() {
		return new RobotPojo(0,LightColor.GREEN,10,5);
	}
}
