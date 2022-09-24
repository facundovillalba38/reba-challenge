package com.reba.service;

import com.reba.entity.db.Person;
import com.reba.entity.dto.PersonDto;
import com.reba.entity.dto.PersonUpdateDto;
import com.reba.exception.ApiCustomException;
import com.reba.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    private PersonRepository personRepository;
    private ModelMapper mapper;

    @Autowired
    public PersonaService(PersonRepository personRepository, ModelMapper mapper){
        this.personRepository = personRepository;
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
}