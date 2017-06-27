package banana.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import banana.bean.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}


}
