package com.example.datajpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Parents")
public class Parents {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
