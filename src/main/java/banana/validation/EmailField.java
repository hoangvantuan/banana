package banana.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import banana.util.string.StringUtil;
import banana.validation.EmailField.EmailFieldValidator;

@Documented
@Constraint(validatedBy = EmailFieldValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailField {

	String message() default "banana.validation.error.user.email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class EmailFieldValidator implements ConstraintValidator<EmailField, String> {
    	@Override
    	public void initialize(EmailField constraintAnnotation) {

    	}

    	@Override
    	public boolean isValid(String value, ConstraintValidatorContext context) {

    		if(StringUtil.isNull(value)) {
    			return false;
    		}

    		if(!value.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
    			return false;
    		}

    		return true;
    	}

    }
}
