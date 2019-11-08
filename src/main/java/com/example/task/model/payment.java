package com.example.task.model;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Email(message="Please provide number")
@Pattern(regexp="[0-10]", message="Please provide number")
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Documented
public @interface payment {

    String message() default "Please provide number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
