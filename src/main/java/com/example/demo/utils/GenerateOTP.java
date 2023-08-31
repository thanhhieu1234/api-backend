package com.example.demo.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GenerateOTP {

	public String createOTP() {
		Random random = new Random();
		int kq = random.nextInt(999999);
		String result = Integer.toString(kq);
		while(result.length() < 6) {
			result = "0" + result;
		}
		
		return result;
	}
}
