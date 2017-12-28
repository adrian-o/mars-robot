package com.aohana.test.marsrobot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.service.RobotService;

@Controller
@RequestMapping("/rest/mars/")
public class RobotController {
	
	@Autowired
	private RobotService robotService;
	
	@GetMapping("{command}")
	public ResponseEntity<Location> move(@PathVariable("command") String command) {
		
		ResponseEntity<Location> response = null;
		
		Location locResult = robotService.move(command);
		
		if(locResult == null) {
			response = new ResponseEntity<Location>(HttpStatus.BAD_REQUEST);
			return response;
		}
		
		response = new ResponseEntity<Location>(locResult, HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/current")
	public ResponseEntity<Location> currentLocation() {
		
		ResponseEntity<Location> response = new ResponseEntity<Location>(robotService.currentLocation(), HttpStatus.OK);
		
		return response;
		
	}
}
