package com.aohana.test.marsrobot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aohana.test.marsrobot.beans.Land;
import com.aohana.test.marsrobot.beans.Robot;

@Configuration
public class BeanConfiguration {

	@Bean
	public Land getLand() {
		return Land.getInstance();
	}

	@Bean
	public Robot getRobot() {
		return Robot.getInstance();
	}
	
}
