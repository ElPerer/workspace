package com.springboot.di.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration

@PropertySources({
	@PropertySource("classpath:textos.properties"),
	@PropertySource("classpath:invoice.properties")
})
public class TextosPropertiesConfig {

}
