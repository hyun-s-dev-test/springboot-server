package com.dev.woo.springbootserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootServerApplication.class, args);
	}
}
