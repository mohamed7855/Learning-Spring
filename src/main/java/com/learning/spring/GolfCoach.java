package com.learning.spring;

public class GolfCoach implements Coach{

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define constructor for dependency injection
	public GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// init method
	public void doMyStartupStuff() {
		System.out.println("GolfCoach: init method");
	}
	
	// destroy method
	public void doMyCloseupStuff() {
		System.out.println("GolfCoach: destroy method");
	}

}
