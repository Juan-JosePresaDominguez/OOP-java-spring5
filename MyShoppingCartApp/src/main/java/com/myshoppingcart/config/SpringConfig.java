package com.myshoppingcart.config;

import com.myshoppingcart.persistence.CompraDBRepository;
import com.myshoppingcart.persistence.ProductoDBRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.myshoppingcart.persistence", "com.myshoppingcart.service"})
@Import({ProductoDBRepository.class, CompraDBRepository.class})
public class SpringConfig {
}
