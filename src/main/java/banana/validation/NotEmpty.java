package banana.validation;

import banana.validation.NotEmpty.NotEmptyFieldValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NotEmptyFieldValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {

  String message() default "banana.validation.error.notempty.field";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class NotEmptyFieldValidator implements ConstraintValidator<NotEmpty, String> {
    @Override
    public void initialize(NotEmpty constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      if(value == null || value.length() == 0) {
        return false;
      }

      return true;
    }

  }
}
