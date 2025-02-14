package com.carlos.curso.springboot.app.springbootcrud.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IsRequired {

  String message() default "{validation.custom.IsRequired}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
