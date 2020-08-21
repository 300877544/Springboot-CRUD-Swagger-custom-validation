package com.example.demo;


import javax.validation.*;
import java.lang.annotation.*;


@Constraint(validatedBy = NameValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "First name and last name should be equal in length";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}