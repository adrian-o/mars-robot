package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;
import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class WestMovement implements MovementSimulator {

	private static WestMovement westMovement;
	
	private WestMovement() {
	}
	
	public static WestMovement getInstance() {
		if(westMovement == null) {
			westMovement = new WestMovement();
		}
		return westMovement;
	}
	
	@Override
	public Location move(Location origin, CommandEnum uniqueCommand) {

		Location locationResult = new Location(origin.getX(),origin.getY(),origin.getDirection());
		
		switch (uniqueCommand) {
			case MOVEMENT:
				if(origin.getX()-1 < 0) {
					throw new IllegalStateException("Invalid movement.");
				}
				locationResult.setX(origin.getX()-1);
				break;
			
			case LEFT:
				locationResult.setDirection(DirectionEnum.SOUTH);
				break;
			
			case RIGHT:
				locationResult.setDirection(DirectionEnum.NORTH);
				break;
			
			default:
				throw new IllegalStateException("Illegal movement");
		}
		
		return locationResult;
		
	}
	
	
}
