package com.baleenn.service.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.baleenn.domain.models.Client;
import com.baleenn.domain.repositories.ClientRepository;
import com.baleenn.dto.request.ClientRequestDto;
import com.baleenn.dto.response.ClientResponseDto;
import com.baleenn.lambda.LambdaTestHandler;
import com.baleenn.service.ClientService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


/**
 * @author Raphael Cremasco
 *
 */
@Service
@Data
@RequiredArgsConstructor
@Log4j2
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository clientRepository;
	@Qualifier("ClientModelMapper") private final ModelMapper modelMapper;

	@Override
	public ClientResponseDto saveClient(ClientRequestDto clientRequestDto) {
		@SuppressWarnings("unused")
		ClientResponseDto clientResponseDto = null;
		try {			
			if (clientRequestDto != null) {
				clientResponseDto = modelMapper.map(
				clientRepository.save(modelMapper.map(clientRequestDto, Client.class)),
				ClientResponseDto.class);
			} else {
				throw new Exception("Client object cannot be null");
			}
			
		} catch (Exception e) {
			log.debug("Shit went wrong", e);
			System.out.println(e);
		}
		return clientResponseDto;		
	}

	@Override
	public ClientResponseDto getClientById(Long clientId) {
		clientRepository.findClientByFirstName("John");
		return null;
	}

}
