package com.paolo.cinemille.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig 
{
    @Bean
    ModelMapper modelMapper()
    {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper
        .getConfiguration()
        .setSkipNullEnabled(true);

        return modelMapper;
    }
	
}
