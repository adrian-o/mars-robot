package com.aohana.test.marsrobot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.aohana.test.marsrobot.beans.Location;
import com.aohana.test.marsrobot.beans.enums.DirectionEnum;
import com.aohana.test.marsrobot.controllers.RobotController;
import com.aohana.test.marsrobot.service.RobotService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(RobotController.class)
public class RobotControllerTests {
	
	@Autowired
    MockMvc mockMvc;
    
	@MockBean
    RobotService robotServiceMock;
    
	@Autowired
    ObjectMapper objectMapper;
	
	@Test
    public void moveRobot() throws Exception {
        
		String command = "RM";
		
		given(robotServiceMock.move(command)).willReturn(new Location(1,0,DirectionEnum.EAST));
        mockMvc.perform(get("/rest/mars/" + command)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(new Location(1,0,DirectionEnum.EAST))))
            .andExpect(status().isOk());
        
    }

	@Test
    public void moveWrongRobot() throws Exception {
		
		String command = "MMMMMMMMMMMMMMMMMM";
		
        given(robotServiceMock.move(command)).willReturn(null);
        mockMvc.perform(get("/rest/mars/"+command)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(null)))
            .andExpect(status().isBadRequest());
        
    }
	
	@Test
    public void invalidCharacterToMoveRobot() throws Exception {
		
		String command = "aMR";
		
        given(robotServiceMock.move(command)).willReturn(null);
        mockMvc.perform(get("/rest/mars/"+command)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsBytes(null)))
            .andExpect(status().isBadRequest());
        
    }
	
}
