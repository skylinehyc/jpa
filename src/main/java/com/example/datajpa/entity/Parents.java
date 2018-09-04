package com.example.datajpa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

    // mappedBy表明了关系被维护端 这样我们就可以通过parents得到对应的students
    // 关系的建立要依赖关系维护端(students)来操作
    @OneToOne(mappedBy = "parents")
    private Students students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parents parents = (Parents) o;
        return Objects.equals(id, parents.id) &&
                Objects.equals(name, parents.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Parents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
