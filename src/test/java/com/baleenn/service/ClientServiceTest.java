package com.baleenn.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.baleenn.domain.models.Client;
import com.baleenn.domain.repositories.ClientRepository;
import com.baleenn.dto.request.ClientRequestDto;
import com.baleenn.dto.response.ClientResponseDto;
import com.baleenn.service.implementations.ClientServiceImpl;

/**
 * @author: rapha
 * @date: Jun. 17, 2021 11:30:18 p.m.
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@Tag("ClientServiceTest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceTest {
	
	private ModelMapper modelMapper;
	private ClientService clientService;
	
	@Mock
	private ClientRepository clientRepository;
	
	private final Long ID = 10L;
	private final String FIRSTNAME = "FIRST_NAME";
	private final String LASTNAME = "LAST_NAME";
	private final String  CELLPHONE = "1234567890";
	private final LocalDate DOB = LocalDate.of(1999, 1, 2);
	
	@Autowired
	ClientServiceTest(@Qualifier("ClientModelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
	
	@BeforeEach
    void setup() {
        this.clientService = new ClientServiceImpl(clientRepository, modelMapper);
        lenient().when(clientRepository.save(any())).thenReturn( generateClientEntity());
    }
	
	private ClientRequestDto generateClientObject() {
		ClientRequestDto clientRequestDto = new ClientRequestDto();
		clientRequestDto.setFirstName(FIRSTNAME);
		clientRequestDto.setLastName(LASTNAME);
		clientRequestDto.setCellphone(CELLPHONE);
		clientRequestDto.setDob(DOB);
		
		return clientRequestDto;
	}
	
	private Client generateClientEntity() {
		Client client = new Client();
		client.setId(ID);
		client.setFirstName(FIRSTNAME);
		client.setLastName(LASTNAME);
		client.setCellphone(CELLPHONE);
		client.setDob(DOB);
		
		return client;
	}
	
	@Test
	@DisplayName("Verifies if the modelMapper maps the object ClientRequestDto to Client")
	void testMapper() {
		
		Client client = new Client();
		ClientRequestDto clientRequestDto = generateClientObject();
 		
		client = modelMapper.map(clientRequestDto, Client.class);
		
		assertEquals(FIRSTNAME, client.getFirstName());
		assertEquals(LASTNAME, client.getLastName());
		assertEquals(CELLPHONE, client.getCellphone());
		assertEquals(DOB, client.getDob());
		
	}
	
	@Test
	@DisplayName("Testing the saving functionality")
	void testSave() {
		ClientRequestDto clientRequestDto = generateClientObject();
		
		ClientResponseDto client = clientService.saveClient(clientRequestDto);
		
		assertEquals(ID, client.getId());
		assertEquals(FIRSTNAME, client.getFirstName());
		assertEquals(LASTNAME, client.getLastName());
		assertEquals(CELLPHONE, client.getCellphone());
		assertEquals(DOB, client.getDob());
		
	}

}
