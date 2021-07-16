package com.baleenn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:messages.kaellum")
public class BaleennApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaleennApplication.class, args);
	}

}
