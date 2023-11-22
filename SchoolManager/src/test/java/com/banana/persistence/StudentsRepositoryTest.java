package com.banana.persistence;

import com.banana.config.SpringConfig;
import com.banana.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = StudentsRepository.class)
@ContextConfiguration(classes = SpringConfig.class)
class StudentsRepositoryTest {

    @Autowired
    private  ApplicationContext context;
    @Autowired
    private StudentsRepositoryInf repoStudents;

//    @BeforeEach
//    //@BeforeAll
//    void setUp() {
//        //context = new ClassPathXmlApplicationContext("beans.xml");
//        context = new AnnotationConfigApplicationContext(StudentsRepository.class);
//        repoStudents = context.getBean(StudentsRepositoryInf.class);
//    }

    @Test
    void testBeans() {
        assertNotNull(context);
        assertNotNull(repoStudents);
        System.out.println(repoStudents.getUrlConn());
    }

    @Test
    void getById() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
//        assertNotNull(context);
//
//        StudentsRepositoryInf repoStudents = context.getBean(StudentsRepositoryInf.class);
//        System.out.println("repoStudents: " + repoStudents);
//        assertNotNull(repoStudents);

        Student aStudent = repoStudents.getById(1L);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 1L);
        assertNotNull(aStudent);
    }

    @Test
    void add() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
//        assertNotNull(context);
//
//        StudentsRepositoryInf repoStudents = context.getBean(StudentsRepositoryInf.class);
//        System.out.println("repoStudents: " + repoStudents);
//        assertNotNull(repoStudents);


        Student newStd = new Student(6L, "El nuevo ", "Apellido", 2);
        System.out.println(newStd);
        repoStudents.add(newStd);
        Student aStudent = repoStudents.getById(6L);
        assertEquals(aStudent.getId(), 6L);
    }

    @Test
    void get() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");
//        assertNotNull(context);
//
//        StudentsRepositoryInf repoStudents = context.getBean(StudentsRepositoryInf.class);
//        System.out.println("repoStudents: " + repoStudents);
//        assertNotNull(repoStudents);

        Student aStudent = repoStudents.get(2);
        System.out.println(aStudent);
        assertEquals(aStudent.getId(), 3L);
        assertNotNull(aStudent);
    }

    @Test
    void testGetById() {
    }
}