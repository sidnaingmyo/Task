package com.example.task.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="Please provide a valid Date")
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface datetimeformatannotation {

    String message() default "{Please provide a valid Date}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };



}


