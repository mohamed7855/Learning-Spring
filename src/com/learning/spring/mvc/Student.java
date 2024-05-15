package com.learning.spring.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String gender;
	private LinkedHashMap<String, String> genderOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap();
		countryOptions.put("Egypt", "Egypt");
		countryOptions.put("USA", "USA");
		countryOptions.put("Algeria", "Algeria");
		countryOptions.put("Bahrin", "Bahrin");
		
		genderOptions = new LinkedHashMap();
		genderOptions.put("Male", "Male");
		genderOptions.put("Female", "Female");
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LinkedHashMap<String, String> getGenderOptions() {
		return genderOptions;
	}
	
	
	
	

}
