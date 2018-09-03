package com.example.datajpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teachers")
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;
}
