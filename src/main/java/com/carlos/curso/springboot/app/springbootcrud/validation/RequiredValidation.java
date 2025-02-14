package com.carlos.curso.springboot.app.springbootcrud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequiredValidation implements ConstraintValidator<IsRequired, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    if (value == null || value.isEmpty() || value.isBlank()) {
      return false;
    }

    return true;
  }
}
