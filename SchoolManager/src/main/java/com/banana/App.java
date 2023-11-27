package com.banana;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import com.banana.services.IStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SchoolManager SPRING
 */
public class App {
    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //context.getEnvironment().matchesProfiles("dev");

        IStudentService servicioEstudiantes= context.getBean(IStudentService.class);

        Student unEstudiante = servicioEstudiantes.getStudentByIndex(3);
        System.out.println(unEstudiante);

        Student otroEstudiante = servicioEstudiantes.getStudentById(3L);
        System.out.println(otroEstudiante);

    }
}
