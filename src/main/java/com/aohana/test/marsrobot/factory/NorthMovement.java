package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Land;
import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;
import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class NorthMovement implements MovementSimulator {

	private static NorthMovement northMovement;
	
	private NorthMovement() {
	}
	
	public static NorthMovement getInstance() {
		if(northMovement == null) {
			northMovement = new NorthMovement();
		}
		return northMovement;
	}
	
	@Override
	public Location move(Location origin, CommandEnum uniqueCommand) {

		Land land = Land.getInstance();
		Location locationResult = new Location(origin.getX(),origin.getY(),origin.getDirection());
		
		switch (uniqueCommand) {
			case MOVEMENT:
				if(origin.getY()+1 > land.getSizeY()-1) {
					throw new IllegalStateException("Invalid movement.");
				}
				locationResult.setY(origin.getY()+1);
				break;
			
			case LEFT:
				locationResult.setDirection(DirectionEnum.WEST);
				break;
			
			case RIGHT:
				locationResult.setDirection(DirectionEnum.EAST);
				break;
			
			default:
				throw new IllegalStateException("Illegal movement");
		}
		
		return locationResult;
		
	}
	
	
}
