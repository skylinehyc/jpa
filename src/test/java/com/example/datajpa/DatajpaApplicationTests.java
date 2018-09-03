package com.example.datajpa;

import com.example.datajpa.entity.Classes;
import com.example.datajpa.entity.Parents;
import com.example.datajpa.entity.Students;
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
        Students students1 = new Students();
        Students students2 = new Students();
        Classes classes = new Classes();
        classes.setNumber("2");
        students1.setName("zhangsan");
        students2.setName("lisi");
        Parents parents1 = new Parents();
        parents1.setName("zhangsan_fumu");
/*        students.add(students1);
        students.add(students2);
        classes.setStudents(students);
        classesRepository.save(classes);*/
        students1.setClasses(classes);
        students1.setParents(parents1);
        studentsRepository.save(students1);



    }

    @Test
    public void testOneToOne() {

    }


    @Test
    public void getinfo() {



        System.out.println(       studentsRepository.findById((long) 1));


    }
}
