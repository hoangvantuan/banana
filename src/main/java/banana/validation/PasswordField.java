package banana.validation;

import banana.util.string.StringUtil;
import banana.validation.PasswordField.PasswordFieldValidator;
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
@Constraint(validatedBy = PasswordFieldValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordField {

  String message() default "banana.validation.error.user.password";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class PasswordFieldValidator implements ConstraintValidator<PasswordField, String> {
    @Override
    public void initialize(PasswordField constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

      if (StringUtil.isNull(value)) {
        return false;
      }

      if (value.length() < 8 || value.length() > 20) {
        return false;
      }

      return true;
    }

  }
}
