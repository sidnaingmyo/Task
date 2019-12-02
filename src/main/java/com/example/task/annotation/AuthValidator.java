package com.example.task.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthValidator implements ConstraintValidator<Auth,String> {

    private String name;


    @Override
    public void initialize(Auth constraintAnnotation) {
        name =constraintAnnotation.value();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(name!=null){
            result =s.equals(name);
        }else {
            result=false;
        }

        return result;
    }
}
