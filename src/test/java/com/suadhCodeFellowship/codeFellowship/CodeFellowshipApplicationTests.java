package com.suadhCodeFellowship.codeFellowship;

import static org.junit.Assert.*;

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

//	@Autowired
//	MockMvc mockMvc;

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


}
