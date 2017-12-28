package com.aohana.test.marsrobot.beans;

import com.aohana.test.marsrobot.beans.enums.DirectionEnum;

public class Location {
	
	private Integer x;
	private Integer y;
	private DirectionEnum direction;
	
	public Location() {
		
	}
	
	public Location(Integer x, Integer y, DirectionEnum direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	
	public Integer getX() {
		return x;
	}
	
	public void setX(Integer x) {
		this.x = x;
	}
	
	public Integer getY() {
		return y;
	}
	
	public void setY(Integer y) {
		this.y = y;
	}
	
	public DirectionEnum getDirection() {
		return direction;
	}
	
	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
	
	
}
