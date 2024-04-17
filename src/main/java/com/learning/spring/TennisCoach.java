package com.learning.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/*
	@Autowired
	@Qualifier("randomFortuneService")
	public void doInjection(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	/*
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		fortuneService = theFortuneService;		
	}*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}
	
	

}
