package com.aohana.test.marsrobot.beans;

import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class Robot {
	
	private Location locationRobot;

	private static Robot robot;
	
	private Robot() {
		this.locationRobot = new Location(0, 0, DirectionEnum.NORTH);
	}
	
	public static Robot getInstance() {
		if(robot == null)
			robot = new Robot();
		
		return robot;
	}
	
	public Location getLocationRobot() {
		return locationRobot;
	}

	public void setLocationRobot(Location locationRobot) {
		this.locationRobot = locationRobot;
	}
	
}