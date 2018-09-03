package com.example.datajpa.repository;

import com.example.datajpa.entity.Students;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students,Long> {


    List<Students> findAllByClassesId(Long id);
}
