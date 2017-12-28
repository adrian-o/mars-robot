package com.aohana.test.marsrobot.beans.enums;

import java.util.Arrays;

public enum CommandEnum {
	
	MOVEMENT("M"), LEFT("L"), RIGHT("R");
	
	private CommandEnum(String label) {
		this.label = label;
	}
	
	private String label;

	public String getLabel() {
		return label;
	}
	
	public static CommandEnum getCommand(String label) {
		return Arrays.stream(CommandEnum.values())
				.filter(com -> com.label.equals(label))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", label)));
	}
}