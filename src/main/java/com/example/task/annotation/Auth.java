package com.example.task.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AuthValidator.class)
public @interface Auth {

    String message() default "{Please provide a valid Date}";

    public String value();
    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
