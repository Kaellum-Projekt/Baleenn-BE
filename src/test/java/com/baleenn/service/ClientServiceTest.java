package com.baleenn.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.baleenn.domain.repositories.ClientRepository;
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
	@SuppressWarnings("unused")
	private ClientService clientService;
	
	@Mock
	private ClientRepository clientRepository;
	
	@Autowired
	ClientServiceTest(@Qualifier("ClientModelMapper") ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
	
	@BeforeEach
    void setup() {
        this.clientService = new ClientServiceImpl(clientRepository, modelMapper);
    }
	
	@Test
	@DisplayName("Not a valid test, this is just to verify if junit + mockit are working fine")
	void mockTest() {
		
		assertTrue(true);
		
	}

}
