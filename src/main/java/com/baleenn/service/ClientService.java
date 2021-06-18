package com.baleenn.service;

import com.baleenn.dto.request.ClientRequestDto;
import com.baleenn.dto.response.ClientResponseDto;

/**
 * @author rapha
 *
 */
public interface ClientService {	
	
	public ClientResponseDto saveClient(ClientRequestDto clientDto);
	
	public ClientResponseDto getClientById(Long clientId);
}
