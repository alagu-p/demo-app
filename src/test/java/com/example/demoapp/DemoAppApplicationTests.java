package com.example.demoapp;

import com.example.demoapp.controller.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebAppConfiguration
@SpringBootTest
class DemoAppApplicationTests {

	@Autowired
	private HomeController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();

	}
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeEach
	private void setUp() throws Exception {
		this.mockMvc= MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	@Test
	public void createUserTest() throws Exception{
		String payload="{\n" +
				"    \"id\": 1,\n" +
				"    \"firstName\": \"alagu\",\n" +
				"    \"lastName\": \"alagu\",\n" +
				"    \"email\": \"alagu@admin.com\",\n" +
				"    \"password\": \"password\",\n" +
				"    \"roles\": [\n" +
				"        {\n" +
				"            \"id\": 1,\n" +
				"            \"name\": \"ROLE_ADMIN\",\n" +
				"            \"description\": \"admin\"\n" +
				"        }\n" +
				"    ]\n" +
				"}";

	mockMvc.perform(post("/user").content(MediaType.APPLICATION_JSON_VALUE).content(payload)).andExpect(status().isOk())
			.andReturn();
	}
	@Test
	public  void fetchUserTest() throws Exception{
		mockMvc.perform(get("/user/{id}",1L)).andExpect(status().isOk());
	}
}
// spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;MODE=MySQL;
// #spring.datasource.username=sa
// #spring.datasource.password=sa
// #spring.datasource.driver-class-name=org.h2.Driver
// #spring.jpa.hibernate.ddl-auto = create-drop
// #spring.jpa.show-sql=true
// #spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
// ##spring.sql.init.continue-on-error=true
// ##spring.jpa.properties.hibernate.format_sql=true