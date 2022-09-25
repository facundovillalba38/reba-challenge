package com.reba.entity.dto;

import com.reba.config.RelationEnumSubset;
import com.reba.entity.RelationEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRelationDto {
    private String dni1;
    private String dni2;
    @RelationEnumSubset(anyOf = {RelationEnum.HERMANX, RelationEnum.PADRE, RelationEnum.TIX, RelationEnum.PRIMX})
    private RelationEnum relation;
}
