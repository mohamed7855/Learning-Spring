package com.learning.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("in Constructor TennisCoach.");
	}

	/*
	 * @Autowired
	 * 
	 * @Qualifier("randomFortuneService") public void doInjection(FortuneService
	 * fortuneService) { this.fortuneService = fortuneService; }
	 */

	/*
	 * @Autowired public TennisCoach(@Qualifier("randomFortuneService")
	 * FortuneService theFortuneService) { fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: init method");
	}

	// destroy method
	@PreDestroy
	public void doMyCloseupStuff() {
		System.out.println("TennisCoach: destroy method");
	}

}
