package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;
import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class SouthMovement implements MovementSimulator {

	private static SouthMovement southMovement;
	
	private SouthMovement() {
	}
	
	public static SouthMovement getInstance() {
		if(southMovement == null) {
			southMovement = new SouthMovement();
		}
		return southMovement;
	}
	
	@Override
	public Location move(Location origin, CommandEnum uniqueCommand) {

		Location locationResult = new Location(origin.getX(),origin.getY(),origin.getDirection());
		
		switch (uniqueCommand) {
			case MOVEMENT:
				if(origin.getY()-1 < 0) {
					throw new IllegalStateException("Invalid movement.");
				}
				locationResult.setY(origin.getY()-1);
				break;
			
			case LEFT:
				locationResult.setDirection(DirectionEnum.EAST);
				break;
			
			case RIGHT:
				locationResult.setDirection(DirectionEnum.WEST);
				break;
			
			default:
				throw new IllegalStateException("Illegal movement");
		}
		
		return locationResult;
		
	}
	
	
}
