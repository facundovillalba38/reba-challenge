package com.reba.service;

import com.reba.entity.RelationEnum;
import com.reba.entity.db.Person;
import com.reba.entity.db.Relation;
import com.reba.entity.dto.PersonRelationDto;
import com.reba.exception.ApiCustomException;
import com.reba.repository.PersonRepository;
import com.reba.repository.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RelationService {

    private PersonRepository personRepository;
    private RelationRepository relationRepository;

    @Autowired
    public RelationService(PersonRepository personRepository, RelationRepository relationRepository){
        this.personRepository = personRepository;
        this.relationRepository = relationRepository;
    }

    public void relatePerson(PersonRelationDto personRelationDto) {
        Person p1 = personRepository.findPersonByDni(personRelationDto.getDni1());
        Person p2 = personRepository.findPersonByDni(personRelationDto.getDni2());
        Relation relation = relationRepository.findByRelation(personRelationDto.getRelation());
        if(p1 == null || p2 == null){
            throw new ApiCustomException("Ambos o algun DNI ingresado es incorrecto.");
        }

        // se chequea la relacion previa de ambos lados, tanto p1 con respecto a p2 y viceversa.
        // Si no hay relacion se procede a crearla
        if(!checkPreviousRelation(p1, p2) && !checkPreviousRelation(p2,p1)){
            Map<Person, Relation> personRelationMap = new HashMap<>();
            personRelationMap.put(p2, relation);
            p1.setRelation(personRelationMap);
            personRepository.save(p1);
        }else{
            throw new ApiCustomException("Las dos personas ingresadas ya tenian una relacion previa.");
        }

    }

    private Boolean checkPreviousRelation(Person p1, Person p2){
        // if this is not null then this two person had a previous relation
        if(p1.getRelation().get(p2)!=null){
            return true;
        }else
            return false;
    }

    public String returnRelation(String dni1, String dni2) {
        Person p1 = personRepository.findPersonByDni(dni1);
        Person p2 = personRepository.findPersonByDni(dni2);
        if(p1 == null || p2 == null){
            throw new ApiCustomException("Ambos o algun DNI ingresado es incorrecto.");
        }
        String relation="";
        if(checkPreviousRelation(p1,p2)){
            relation = p1.getRelation().get(p2).getRelation().name();
        }else if(checkPreviousRelation(p2,p1)){
            relation = p2.getRelation().get(p1).getRelation().name();
        }else {
            relation = "No existe relacion entre las personas consultadas";
        }

        return relation;

    }
}
