package com.reba.entity.dto;

import com.reba.config.RelationEnumSubset;
import com.reba.entity.RelationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRelationDto {
    private String dni1;
    private String dni2;
    @RelationEnumSubset(anyOf = {RelationEnum.HERMANX, RelationEnum.PADRE, RelationEnum.TIX, RelationEnum.PRIMX})
    private RelationEnum relation;
}
