package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FormSignIn implements Validator {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public FormSignIn() {
    }

    public FormSignIn(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FormSignIn.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FormSignIn formSignIn = (FormSignIn) target;

        String firstName = formSignIn.getFirstName();





        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        boolean checkFirstName = firstName.length() > 45 || firstName.length() < 5;

        if (checkFirstName) {
            errors.rejectValue("firstName", "firstName.length");

        }



        String lastName = formSignIn.getLastName();
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        boolean checkLastName = lastName.length() > 45 || lastName.length() < 5;

        if (checkLastName) {
            errors.rejectValue("lastName", "lastName.length");
        }


        //check Phone
        String phoneNumber = formSignIn.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        boolean checkPhoneNumberLength = phoneNumber.length() > 11 || phoneNumber.length() < 10;
        if (checkPhoneNumberLength) {
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }


        int age = formSignIn.getAge();
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age < 18) {
            errors.rejectValue("age", "age.value");
        }


        String email = formSignIn.getEmail();
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!email.matches("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)")) {
            errors.rejectValue("email", "email.matches");
        }
    }
}
