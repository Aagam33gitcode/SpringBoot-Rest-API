package com.example.springComplete.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class empCongif{
    @Bean
    public ModelMapper mapper(){
    return new ModelMapper();
    }
}

