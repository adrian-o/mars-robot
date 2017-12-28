package com.aohana.test.marsrobot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.Robot;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;
import com.aohana.test.marsrobot.factory.MovementFactory;
import com.aohana.test.marsrobot.factory.MovementSimulator;

@Service
public class RobotServiceImpl implements RobotService {

	@Autowired
	public Robot robot;
	
	@Override
	public Location move(String command) {
	
		if(isCommandValid(command)) {
			
			List<Location> locSim = new ArrayList<>();
			locSim.add(robot.getLocationRobot());
			char[] characters = command.toCharArray();
			
			for(Character charac : characters) {
				try {
					CommandEnum commandEnum = CommandEnum.getCommand(charac.toString());
					Location origin = locSim.get(locSim.size()-1);
					MovementSimulator simulator = MovementFactory.getMovementSimulator(origin);
					locSim.add(simulator.move(origin, commandEnum));
				}catch (IllegalStateException ise) {
					return null;
				}
			}
			
			locSim.forEach(loc -> robot.setLocationRobot(loc));
			
			return robot.getLocationRobot();
		}
	
		return null;
	
	}

	@Override
	public Location currentLocation() {
		return robot.getLocationRobot();
	}
	
	private Boolean isCommandValid(String command) {
		Pattern pattern = Pattern.compile("[^MLR]");
	    Matcher matcher = pattern.matcher(command);
	    return !(matcher.find());
	}
}
