package com.reba.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class PersonDto {
    @NotBlank(message = "Debe completar el nombre")
    private String name;
    @NotBlank(message = "Debe completar el apellido")
    private String lastname;
    @NotBlank(message = "Debe completar la edad")
    @Min(18)
    private Integer age;
    private String nationality;
    @Email(message = "Debe ingresar un email con formato valido")
    private String email;
    private String telephoneNumber;
    @NotBlank(message = "Debe completar el dni")
    private String dni;
}
