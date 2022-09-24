package com.reba.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class PersonDto {
    @NotNull(message = "Debe completar el nombre")
    private String name;
    @NotNull(message = "Debe completar el apellido")
    private String lastname;
    @NotNull(message = "Debe ingresar la edad")
    @Min(18)
    private Integer age;
    private String nationality;
    private String email;
    private String telephoneNumber;
    @NotBlank(message = "Debe completar el dni")
    private String dni;
}
