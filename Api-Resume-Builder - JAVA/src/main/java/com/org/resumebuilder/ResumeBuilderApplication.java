package com.org.resumebuilder;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResumeBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.addConverter(new StringToDateConverter());
		return modelMapper;
	}
}
