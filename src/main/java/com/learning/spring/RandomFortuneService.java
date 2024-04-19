package com.learning.spring;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	public RandomFortuneService() {
		System.out.println("in Constructor FortuneService.");
	}

	private String[] data = { "Hello Mohamed", "Hello Salem", "Hello Khaled" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {

		int index = myRandom.nextInt(data.length);

		String theFortune = data[index];

		return theFortune;
	}

}
