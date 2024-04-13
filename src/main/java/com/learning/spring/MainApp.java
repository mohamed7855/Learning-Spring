package com.learning.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", Coach.class);
		Coach theCoach2 = context.getBean("myBaseballCoach", Coach.class);
		BaseballCoach theCoach3 = context.getBean("myBaseballCoach", BaseballCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach2.getDailyWorkout());
		System.out.println(theCoach2.getDailyFortune());
		
		System.out.println(theCoach3.getTeam());
		System.out.println(theCoach3.getEmail());

		// close the context
		context.close();
	}
}
