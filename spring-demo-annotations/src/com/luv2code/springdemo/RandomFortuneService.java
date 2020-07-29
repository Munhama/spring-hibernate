package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create a String Array List
	private ArrayList<String> list = new ArrayList<String>();
	
	private String fileName = "src/fortune.txt";
	
	// create a random number generation
	private Random random = new Random();
	
	// method for read file post create bean
	@PostConstruct
	public void loadFile() throws Exception {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));		
			String str;
			while((str = reader.readLine()) != null) {
				list.add(str);
			}
			reader.close();
	}
	
	@Override
	public String getFortune() {
		// pick a random string from the Array List
		int index = random.nextInt(list.size());
		
		return list.get(index);
	}

}
