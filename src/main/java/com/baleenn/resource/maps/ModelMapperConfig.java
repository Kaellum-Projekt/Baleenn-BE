package com.baleenn.resource.maps;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

/**
 * @author: rapha
 * @date: Jun. 16, 2021 9:57:06 p.m.
 */
@Configuration
@Log4j2
public class ModelMapperConfig {
	
	@Bean("ClientModelMapper")
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration()
        .setMatchingStrategy(MatchingStrategies.STRICT)
        .setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PUBLIC)
        .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
        .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE)
        .setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR)
        .setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
				
		log.info("==> modelMapper :{}", modelMapper);
		
		return modelMapper;
		
	}

}
