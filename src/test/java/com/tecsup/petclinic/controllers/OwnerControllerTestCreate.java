package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.dto.OwnerDTO;
@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerTestCreate {
	private static final Logger logger 
			= LoggerFactory.getLogger(OwnerControllerTestCreate.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	/**
	 * @throws Exception
	 */
	@Test
	public void testCreateOwner() throws Exception {
		String FIRST_NAME = "Diego";
		String LAST_NAME = "Mendez";
		String ADDRESS = "1258 Santa Rosita";
		String CITY = "Lima";
		String TELEPHONE = "999536259";
		
		OwnerDTO newOwner = new OwnerDTO(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		
		logger.info(newOwner.toString());
		logger.info(om.writeValueAsString(newOwner));
		
		mockMvc.perform(post("/owners")
	            .content(om.writeValueAsString(newOwner))
	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated())
	            .andExpect(jsonPath("$.first_name", is(FIRST_NAME)))
	            .andExpect(jsonPath("$.last_name", is(LAST_NAME)))
	            .andExpect(jsonPath("$.address", is(ADDRESS)))
	    		.andExpect(jsonPath("$.city", is(CITY)))
	    		.andExpect(jsonPath("$.telephone", is(TELEPHONE)));
	}
}
