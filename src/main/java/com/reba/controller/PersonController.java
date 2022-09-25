package com.reba.controller;

import com.reba.entity.dto.PersonDto;
import com.reba.entity.dto.PersonRelationDto;
import com.reba.entity.dto.PersonUpdateDto;
import com.reba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/persona")
public class PersonController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    private ResponseEntity createPersona(@Valid @RequestBody PersonDto personDto){
        personaService.createPersona(personDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{dni}")
    private ResponseEntity<PersonDto> getPersona(@PathVariable("dni") String dni){
        return new ResponseEntity<>(personaService.getPersona(dni), HttpStatus.OK);
    }

    @PutMapping("/{dni}")
    private ResponseEntity updatePersona(@PathVariable("dni")String dni,@Valid @RequestBody PersonUpdateDto personUpdateDto){
        personaService.updatePersona(dni, personUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{dni}")
    private ResponseEntity deletePersona(@PathVariable("dni") String dni){
        personaService.deletePersona(dni);
        return new ResponseEntity(HttpStatus.OK);
    }
}
