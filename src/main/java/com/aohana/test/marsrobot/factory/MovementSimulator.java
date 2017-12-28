package com.aohana.test.marsrobot.factory;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.CommandEnum;

public interface MovementSimulator {

	Location move(Location origin, CommandEnum command);
}
