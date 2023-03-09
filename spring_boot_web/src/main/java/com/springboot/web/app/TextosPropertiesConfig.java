package com.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	//El classpath es donde está la carpeta src/main/resources, es decir donde debería de estar ubicado este archivo property
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
