package com.reba.controller;

import com.reba.entity.RelationEnum;
import com.reba.entity.dto.PersonRelationDto;
import com.reba.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/relaciones")
public class RelationController {

    private RelationService relationService;

    @Autowired
    public RelationController(RelationService relationService){
        this.relationService = relationService;
    }

    @PostMapping
    private ResponseEntity relatePerson(@Valid @RequestBody PersonRelationDto personRelationDto){
        relationService.relatePerson(personRelationDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{dni1}/{dni2}")
    private ResponseEntity<String> returnRelation(@PathVariable("dni1") String dni1, @PathVariable("dni2") String dni2){
        return new ResponseEntity(relationService.returnRelation(dni1, dni2), HttpStatus.OK);
    }
}
