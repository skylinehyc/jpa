package com.example.datajpa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="classes")
public class Classes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    // mappedBy -- 指定被控方 此时只有主控方更新数据才会级联操作到被控方
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "classes")
    // JoinColumn 和 mappedBy 互斥 ，使用JoinColumn 则双方都能维护
//    @JoinColumn(name = "classe_id")
    private Set<Students> students;




}
