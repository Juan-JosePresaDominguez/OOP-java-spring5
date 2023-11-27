package com.banana;

import com.banana.models.Student;
import com.banana.persistence.StudentsRepositoryInf;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        //Test: debería responder con verdadero
        //ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        assertNotNull(context);

        StudentsRepositoryInf repoStudents = context.getBean(StudentsRepositoryInf.class);
        System.out.println("repoStudents: " + repoStudents);
        assertNotNull(repoStudents);

        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertNotNull(aStudent);
    }
}
