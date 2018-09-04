package com.example.datajpa;

import com.example.datajpa.entity.Classes;
import com.example.datajpa.entity.Parents;
import com.example.datajpa.entity.Students;
import com.example.datajpa.entity.Teachers;
import com.example.datajpa.repository.ClassesRepository;
import com.example.datajpa.repository.StudentsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatajpaApplicationTests {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Test
    public void contextLoads() {

        Set<Students> students = new HashSet<>();
        Students students2 = new Students();

        Students students1 = new Students();
        Classes classes = new Classes();

        Parents parents1 = new Parents();

        Set<Teachers> teachers = new HashSet<>();
        Teachers teacher1 = new Teachers();
        Teachers teacher2 = new Teachers();

        students1.setName("zhangsan");
        classes.setNumber("2");
        parents1.setName("zhangsan_fumu");

        teacher1.setName("teacher_1");
        teacher2.setName("teacher_2");
        teachers.add(teacher1);
        teachers.add(teacher2);

/*        students.add(students1);
        students.add(students2);
        classes.setStudents(students);
        classesRepository.save(classes);*/
        students1.setClasses(classes);
        students1.setParents(parents1);
        students1.setTeachers(teachers);
        studentsRepository.save(students1);



    }

    @Test
    public void testOneToOne() {

    }


    @Test
    public void getinfo() {



        System.out.println(       classesRepository.findById((long) 1));


    }
}
