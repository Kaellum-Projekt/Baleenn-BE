package com.baleenn.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LambdaTestResponse {
	
	private String testVariableString;
	private Integer TestVariableInt;
	private Long testVariableLong;
	private Boolean testVariableBool;

	@Builder(builderMethodName = "lambdaTstBuilder")
	public static LambdaTestResponse lambdaBuilder(String stringOfValues) {
		String[] values = stringOfValues.split("|");
		LambdaTestResponse lambda = new LambdaTestResponse();
		lambda.setTestVariableBool(Boolean.valueOf(values[0]));
		lambda.setTestVariableInt(Integer.valueOf(values[1]));
		lambda.setTestVariableLong(Long.valueOf(values[2]));
		lambda.setTestVariableString(values[3]);
		return lambda;
	}
	
}
