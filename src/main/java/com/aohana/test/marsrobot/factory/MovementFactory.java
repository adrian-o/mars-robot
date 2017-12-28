package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Location;

public class MovementFactory {
	
	public static MovementSimulator getMovementSimulator(Location origin) {
		
		MovementSimulator movementSimulator = null;
		
		switch (origin.getDirection()) {
			case NORTH:
				movementSimulator = NorthMovement.getInstance();
				break;
			
			case SOUTH:
				movementSimulator = SouthMovement.getInstance();
				break;	
			
			case WEST:
				movementSimulator = WestMovement.getInstance();
				break;
			
			case EAST:
				movementSimulator = EastMovement.getInstance();
				break;
				
		}
		
		return movementSimulator;
		
	}
}