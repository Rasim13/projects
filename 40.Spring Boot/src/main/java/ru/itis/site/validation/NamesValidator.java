package ru.itis.site.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NamesValidator implements ConstraintValidator<NotSameNames, Object> {

    private String firstNameField;
    private String lastNameField;

    // данный метод позволяет сохранять в поля firstNameField, lastNameField, поля которые указаны в классе
    // signUpForm т.е. firstName и lastName
    @Override
    public void initialize(NotSameNames constraintAnnotation) {
        this.firstNameField = constraintAnnotation.firstNameField();
        this.lastNameField = constraintAnnotation.lastNameField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object firstNameValue = new BeanWrapperImpl(value).getPropertyValue(firstNameField);
        Object lastNameValue = new BeanWrapperImpl(value).getPropertyValue(lastNameField);
        return firstNameValue != null && !firstNameValue.equals(lastNameValue);
    }
}
