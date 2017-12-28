package com.aohana.test.marsrobot.beans.enums;

import java.util.Arrays;

public enum DirectionEnum {
	
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private DirectionEnum(String label) {
		this.label = label;
	}
	
	private String label;

	public String getLabel() {
		return label;
	}
	
	public static DirectionEnum getDirection(String label) {
		return Arrays.stream(DirectionEnum.values())
				.filter(dir -> dir.label.equals(label))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", label)));
	}
}