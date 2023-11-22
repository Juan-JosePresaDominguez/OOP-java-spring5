package com.myshoppingcart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@Import({ReposConfig.class, ServicesConfig.class})
public class SpringConfig {
}
