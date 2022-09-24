package com.reba.entity.dto;

import lombok.Getter;

import javax.validation.constraints.Min;

@Getter
public class PersonUpdateDto {
    private String name;
    private String lastname;
    @Min(18)
    private Integer age;
    private String nationality;
    private String email;
    private String telephoneNumber;
}
