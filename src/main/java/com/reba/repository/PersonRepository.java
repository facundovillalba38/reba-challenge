package com.reba.repository;

import com.reba.entity.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByDni(String dni);
}
