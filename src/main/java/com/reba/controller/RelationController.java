package com.reba.controller;

import com.reba.entity.dto.PersonRelationDto;
import com.reba.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/relacion")
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
}
