package com.aohana.test.marsrobot.beans;

public class Land {
	
	private Integer sizeX;
	private Integer sizeY;
	
	private static Land land;
	
	private Land() {
		this.sizeX = 5;
		this.sizeY = 5;
	}
	
	public static Land getInstance() {
		if(land == null)
			land = new Land();
		
		return land;
	}
	
	public Integer getSizeX() {
		return sizeX;
	}
	
	public void setSizeX(Integer sizeX) {
		this.sizeX = sizeX;
	}
	
	public Integer getSizeY() {
		return sizeY;
	}
	
	public void setSizeY(Integer sizeY) {
		this.sizeY = sizeY;
	}
	
}
