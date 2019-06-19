package com.suadhCodeFellowship.codeFellowship;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.suadhCodeFellowship.codeFellowship.AppUser.AppUserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CodeFellowshipApplicationTests{

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Autowired
	AppUserController appUserController;

	@Autowired
	CodeFellowshipController codeFellowshipController;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testAppControllerIsAutowired() {
		assertNotNull(appUserController);
	}

	@Test
	public void testCodeControllerIsAutowired() {
		assertNotNull(codeFellowshipController);
	}

	@Test
	public void testRequestToRootGivesWelcome() throws Exception {
		mockMvc.perform(get("/")).andExpect(content().string(containsString("Welcome to our home")));
	}

	@Test
	public void testRequestToSignUpGivesSignUP() throws Exception {
		mockMvc.perform(get("/signup")).andExpect(content().string(containsString("User Name")));
	}

}
