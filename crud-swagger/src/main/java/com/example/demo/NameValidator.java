package com.example.demo;

import com.example.demo.Entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameConstraint, User> {
    @Override
    public void initialize(NameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        User user1 = (User) user;
        String firstname = user1.getFirstName();
        String lastname = user1.getLastName();
        if (firstname.length() == lastname.length())
        {
            return  true;
        }

        return false;
    }



}
