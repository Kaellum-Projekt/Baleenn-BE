package com.baleenn.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.baleenn.dto.response.LambdaTestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LabdaTestHandler implements RequestHandler<String, LambdaTestResponse>{
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	@Override
	public LambdaTestResponse handleRequest(String input, Context context) {
		LambdaLogger logger = context.getLogger();
		
		logger.log("EVENT INPUT: " + gson.toJson(input));
	    logger.log("EVENT TYPE INPUT: " + input.getClass().toString());
	    
		LambdaTestResponse output = LambdaTestResponse.lambdaTstBuilder().stringOfValues(input).build();
	    
		logger.log("EVENT OUTPUT: " + gson.toJson(output));
	    logger.log("EVENT TYPE OUTPUT: " + output.getClass().toString());
		
	    return output;
	}

}
