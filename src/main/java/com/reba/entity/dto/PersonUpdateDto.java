package com.reba.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonUpdateDto {
    private String name;
    private String lastname;
    @Min(18)
    private Integer age;
    private String nationality;
    private String email;
    private String telephoneNumber;
}
