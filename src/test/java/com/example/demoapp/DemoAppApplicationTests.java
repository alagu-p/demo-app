package com.example.demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoAppApplicationTests {

	@Autowired
	private HomeController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();

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