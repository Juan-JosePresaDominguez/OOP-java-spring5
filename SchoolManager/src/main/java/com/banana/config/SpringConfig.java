package com.banana.config;

import com.banana.persistence.StudentsRepository;
import com.banana.persistence.StudentsRepositoryInf;
import com.banana.services.IStudentService;
import com.banana.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"com.banana.persistence", "com.banana.services"})
//@Import({StudentsRepository.class, StudentsService.class})
@Import({ReposConfig.class, ServicesConfig.class})
public class SpringConfig {

//    @Bean
//    public StudentsRepositoryInf getStudentsRepository() {
//        StudentsRepository repo = new StudentsRepository();
//        repo.setUrlConn("jdbc://.....");
//        return repo;
//    }
//
//    //Definir una variable repositorio de tipo interface
//    @Autowired
//    StudentsRepositoryInf repo;
//
//    @Bean
//    public IStudentService createStudentService() {
//        StudentsService service = new StudentsService();
//        StudentsRepository repo = new StudentsRepository();
//        service.setRepository(repo);
//        return service;
//    }

}