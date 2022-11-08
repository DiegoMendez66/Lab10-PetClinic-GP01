package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dto.OwnerDTO;
import com.tecsup.petclinic.dto.PetDTO;
@AutoConfigureMockMvc
@SpringBootTest
public class OwenerControllerTestDelete {
	private static final Logger logger 
			= LoggerFactory.getLogger(OwenerControllerTestDelete.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	/**
	 * @throws Exception
	 */
    @Test
	public void testDeleteOwner() throws Exception {
		String FIRST_NAME = "Benja";
		String LAST_NAME = "Solier";
		String ADDRESS = "1258 Su casa ";
		String CITY = "Lima";
		String TELEPHONE = "999999959";
		
		OwnerDTO newOwner = new OwnerDTO(FIRST_NAME, LAST_NAME, ADDRESS, CITY, TELEPHONE);
		
		ResultActions mvcActions = mockMvc.perform(post("/owners")
	            .content(om.writeValueAsString(newOwner))
	            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated());            
		String response = mvcActions.andReturn().getResponse().getContentAsString();

		Integer id = JsonPath.parse(response).read("$.id");

        mockMvc.perform(delete("/owners/" + id ))
                 /*.andDo(print())*/
                .andExpect(status().isOk());
    }
}