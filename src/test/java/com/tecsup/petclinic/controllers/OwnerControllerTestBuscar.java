package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;




/**
 * 
 */
@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerTestBuscar {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testFindOwnerOK() throws Exception {

		int ID_SEARCH = 5;
		String NAME = "Peter";
		String LASTNAME = "McTavish";
		String ADDRESS = "2387 S. Fair Way";
		String CITY = "Madison";
		String TELEPHONE = "6085552765";
		
		/*
		 {
		   	int ID_SEARCH = 5;
			String NAME = "Peter";
			String LASTNAME = "McTavish";
			String ADDRESS = "2387 S. Fair Way";
			String CITY = "Madison";
			String TELEPHONE = "6085552765";
		}
		 */

		
		mockMvc.perform(get("/owners/" + ID_SEARCH))  // Finding object with ID = 5
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				//.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(ID_SEARCH)))
				.andExpect(jsonPath("$.first_name", is(NAME)))
				.andExpect(jsonPath("$.last_name", is(LASTNAME)))
				.andExpect(jsonPath("$.address", is(ADDRESS)))
				.andExpect(jsonPath("$.city", is(CITY)))
				.andExpect(jsonPath("$.telephone", is(TELEPHONE)));

	}
	
}
