package com.baleenn.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.baleenn.dto.response.LambdaTestResponseDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LambdaTestHandler implements RequestHandler<String, LambdaTestResponseDto>{
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	@Override
	public LambdaTestResponseDto handleRequest(String input, Context context) {
		//"true;10;20L;TEST LAMBDA";
		LambdaLogger logger = context.getLogger();
		
		//logger.log("EVENT INPUT: " + gson.toJson(input));
	    logger.log("EVENT TYPE INPUT: " + input.getClass().toString());
	    
		LambdaTestResponseDto output = LambdaTestResponseDto.lambdaTstBuilder().stringOfValues(input).build();
	    
		logger.log("EVENT OUTPUT: " + gson.toJson(output));
	    logger.log("EVENT TYPE OUTPUT: " + output.getClass().toString());
		
	    return output;
	}

}
