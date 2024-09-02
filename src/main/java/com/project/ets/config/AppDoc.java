package com.project.ets.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class AppDoc 
{
	Info info() {
		return new Info().title("").version("V1").description("");
	}
	
}
