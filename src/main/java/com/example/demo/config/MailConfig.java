package com.example.demo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	private String host = "smtp.gmail.com";

	private Integer port = 587;

	private String email = "hieuvntps20404@fpt.edu.vn";;

	private String password = "uhrsmlyusozngiae";;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setPort(port);
		mailSender.setHost(host);
		mailSender.setUsername(email);
		mailSender.setPassword(password);		
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.from", email);
		props.put("mail.debug", "true");

		return mailSender;
	}
}
