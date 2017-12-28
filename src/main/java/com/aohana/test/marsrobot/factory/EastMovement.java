package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Land;
import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;
import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class EastMovement implements MovementSimulator {

	private static EastMovement eastMovement;
	
	private EastMovement() {
	}
	
	public static EastMovement getInstance() {
		if(eastMovement == null) {
			eastMovement = new EastMovement();
		}
		return eastMovement;
	}
	
	@Override
	public Location move(Location origin, CommandEnum uniqueCommand) {

		Land land = Land.getInstance();
		Location locationResult = new Location(origin.getX(),origin.getY(),origin.getDirection());
		
		switch (uniqueCommand) {
			case MOVEMENT:
				if(origin.getX()+1 > land.getSizeX()-1) {
					throw new IllegalStateException("Invalid movement.");
				}
				locationResult.setX(origin.getX()+1);
				break;
			
			case LEFT:
				locationResult.setDirection(DirectionEnum.NORTH);
				break;
			
			case RIGHT:
				locationResult.setDirection(DirectionEnum.SOUTH);
				break;
			
			default:
				throw new IllegalStateException("Illegal movement");
		}
		
		return locationResult;
		
	}
	
	
}
