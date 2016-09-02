package io.github.xeyez.newuser;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import io.github.xeyez.domain.NewUserVO;

public class NewUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NewUserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userpw", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "required");
		
		NewUserVO newUser = (NewUserVO) target;
		if (!newUser.isPasswordAndConfirmSame())
			errors.rejectValue("confirm", "notSame");
	}

}
