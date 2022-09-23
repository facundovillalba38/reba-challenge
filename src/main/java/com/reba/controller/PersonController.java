package com.reba.controller;

import com.reba.entity.dto.PersonDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonController {

    @PostMapping
    private void createPersona(PersonDto personDto){
        System.out.println(personDto);
    }
}
