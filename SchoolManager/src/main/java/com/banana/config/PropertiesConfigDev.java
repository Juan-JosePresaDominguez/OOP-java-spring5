package com.banana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-dev.properties")
@Profile("dev")  //Esto le indica a Spring que este perfil es sólo para desarrollo.
public class PropertiesConfigDev {
}
