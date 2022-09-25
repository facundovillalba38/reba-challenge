package com.reba.service;

import com.reba.entity.RelationEnum;
import com.reba.entity.db.Person;
import com.reba.entity.db.Relation;
import com.reba.entity.dto.PersonDto;
import com.reba.entity.dto.PersonRelationDto;
import com.reba.entity.dto.PersonUpdateDto;
import com.reba.exception.ApiCustomException;
import com.reba.repository.PersonRepository;
import com.reba.repository.RelationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonaService {

    private PersonRepository personRepository;
    private RelationRepository relationRepository;
    private ModelMapper mapper;

    @Autowired
    public PersonaService(PersonRepository personRepository, RelationRepository relationRepository, ModelMapper mapper){
        this.personRepository = personRepository;
        this.relationRepository = relationRepository;
        this.mapper = mapper;
    }



    public void createPersona(PersonDto personDto){
        Person person = mapper.map(personDto, Person.class);
        if(personExists(person)){
            throw new ApiCustomException("La persona que esta intentando ingresar ya existe.");
        }else{
            personRepository.save(person);
        }
    }

    private Boolean personExists(Person person){
        Person personExists = personRepository.findPersonByDni(person.getDni());
        if(personExists != null){
            return true;
        }else{
            return false;
        }
    }

    public PersonDto getPersona(String dni) {
        Person person = personRepository.findPersonByDni(dni);
        if(person != null){
            return buildPersonaDto(person);
        }else{
            throw new ApiCustomException("La persona con el DNI ingresado no existe.");
        }
    }

    private PersonDto buildPersonaDto(Person person) {
        return PersonDto.builder()
                .age(person.getAge())
                .name(person.getName())
                .lastname(person.getLastname())
                .nationality(person.getNationality())
                .email(person.getEmail())
                .telephoneNumber(person.getTelephoneNumber())
                .dni(person.getDni())
                .build();
    }

    public void updatePersona(String dni, PersonUpdateDto personUpdateDto) {
        Person person = personRepository.findPersonByDni(dni);
        if(person == null){
            throw new ApiCustomException("La persona con el DNI ingresado no existe.");
        }else{
            person = buildUpdatePersona(person, personUpdateDto);
            personRepository.save(person);
        }
    }

    private Person buildUpdatePersona(Person person, PersonUpdateDto personUpdateDto){
        if(personUpdateDto.getName() != null){
            person.setName(personUpdateDto.getName());
        }
        if(personUpdateDto.getLastname() != null){
            person.setLastname(personUpdateDto.getLastname());
        }
        if(personUpdateDto.getAge()!=null){
            person.setAge(personUpdateDto.getAge());
        }
        if(personUpdateDto.getEmail() != null){
            person.setEmail(personUpdateDto.getEmail());
        }
        if(personUpdateDto.getNationality()!=null){
            person.setNationality(personUpdateDto.getNationality());
        }
        if(personUpdateDto.getTelephoneNumber()!=null){
            person.setTelephoneNumber(personUpdateDto.getTelephoneNumber());
        }
        return person;
    }

    public void deletePersona(String dni) {
        Person person = personRepository.findPersonByDni(dni);
        if(person == null){
            throw new ApiCustomException("La persona con el DNI ingresado no existe.");
        }else{
            personRepository.delete(person);
        }
    }

    public Boolean isFather(String dni1, String dni2) {
        Person p1 = personRepository.findPersonByDni(dni1);
        Person p2 = personRepository.findPersonByDni(dni2);
        if(p1 == null || p2 == null){
            throw new ApiCustomException("Ambos o algun DNI ingresado es incorrecto.");
        }

        // primero se fija si existe una relacion previa Y si esa relacion es la de PADRE
        if(p1.getRelation().get(p2) != null && p1.getRelation().get(p2).getRelation() == RelationEnum.PADRE){
            return true;
        }else{
            return false;
        }
    }
}
