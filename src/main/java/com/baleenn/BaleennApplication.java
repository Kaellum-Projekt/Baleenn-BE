package com.baleenn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.baleenn.lambda.LambdaTestHandler;

@SpringBootApplication
@PropertySource("classpath:messages.kaellum")
public class BaleennApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BaleennApplication.class, args);
//		
//		LambdaTestHandler test = new LambdaTestHandler();
//		
//		System.out.println(test.handleRequest("true;10;20;TEST LAMBDA", null));
	}

}
