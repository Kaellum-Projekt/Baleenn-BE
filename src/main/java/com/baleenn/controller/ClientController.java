package com.baleenn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baleenn.dto.request.ClientRequestDto;
import com.baleenn.dto.response.ClientResponseDto;
import com.baleenn.service.ClientService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author rapha
 */
@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {
	
	private final ClientService clientService;
	
	@RequestMapping(method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
		
		return clientService.saveClient(clientRequestDto);
		
	}
	
	@RequestMapping(method = {RequestMethod.GET}, path = "/test")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String test ()  {
		
		return "Test functions perfectly";
		
	}
	
	

}
