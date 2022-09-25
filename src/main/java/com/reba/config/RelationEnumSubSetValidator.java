package com.reba.config;

import com.reba.entity.RelationEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class RelationEnumSubSetValidator implements ConstraintValidator<RelationEnumSubset, RelationEnum> {
    private RelationEnum[] subset;

    @Override
    public void initialize(RelationEnumSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(RelationEnum value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
