package com.example.datajpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
    @JoinColumn(name = "parents_id", referencedColumnName = "id" ,unique = true)
    private Parents parents;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            // 中间表名称
            name = "students_teachers",
            // 学生表的外键
            joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
            // 老师表的外键
            inverseJoinColumns = {@JoinColumn(name = "teacher_id",referencedColumnName = "id")}
    )
    private Set<Teachers> teachers;


    @Override
    public int hashCode() {

        return Objects.hash(id, name,parents,teachers);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parents='" + parents + '\'' +
                ", teachers='" + teachers + '\'' +
                '}';
    }
}
