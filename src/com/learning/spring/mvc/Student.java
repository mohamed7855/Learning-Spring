package com.learning.spring.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.learning.spring.mvc.validation.SubjectCode;

public class Student {
	
	@NotNull(message="is required")
	@Size(min = 3, message="is required")
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min = 2, message="is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value =18 , message = "must be greater than or equal to 18")
	@Max(value =40 , message = "must be less than or equal to 40")
	private Integer age;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
//	@SubjectCode(value = "ABC-", message = "must start with ABC-")
	@SubjectCode
	private String subjectCode;
	
	public Student() {
		
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	
	

}
