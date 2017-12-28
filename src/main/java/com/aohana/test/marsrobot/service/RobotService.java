package com.aohana.test.marsrobot.service;

import com.aohana.test.marsrobot.beans.Location;

public interface RobotService {
	
	Location move(String command);
	Location currentLocation();
}
