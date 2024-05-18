package com.learning.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SubjectCodeConstraintValidator implements ConstraintValidator<SubjectCode, String>{

	private String subjectPrefix;
	@Override
	public void initialize(SubjectCode theSubjectCode) {
		subjectPrefix = theSubjectCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		if (theCode != null) {
			result = theCode.startsWith(subjectPrefix);
		}
		else {
			result = true;
		}
		return result;
	}
	
	
}
