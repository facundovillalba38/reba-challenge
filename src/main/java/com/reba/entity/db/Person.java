package com.reba.entity.db;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String lastname;
    Integer age;
    String nationality;
    String email;
    String telephoneNumber;
    String dni;
    @ManyToMany
    Map<Person, Relation> relation;


}
