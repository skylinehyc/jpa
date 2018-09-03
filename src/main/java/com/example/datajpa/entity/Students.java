package com.example.datajpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    // 多对一的注解
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // referencedColumnName 关联类（表）在数据库中的关联字段名
    // name 本类（表）在数据库的字段名
    @JoinColumn(name = "classe_id", referencedColumnName = "id" )
    @JsonIgnore
    private Classes classes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parents_id",unique = true)
    private Parents parents;



    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
