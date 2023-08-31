package com.example.demo.service;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.utils.GenerateOTP;
import com.example.demo.utils.MailUtil;

@Service
public class MailService {

	@Autowired
	MailUtil mailUtil;

	@Autowired
	GenerateOTP generateOTP;

	@Autowired
	IUserRepository iUserRepository;

	public String create(RegisterDTO registerDTO) {
		String otp = generateOTP.createOTP();
		try {
			mailUtil.sendMail(registerDTO.getEmail(), otp);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		user.setEmail(registerDTO.getEmail());
		user.setOtp(otp);
		user.setUsername(registerDTO.getUsername());
		user.setPassword(registerDTO.getPassword());
		user.setDateTime(LocalDateTime.now());
		user.setStatus(false);
		user = iUserRepository.save(user);
		if (user != null) {
			return "Register user susscess";
		}
		return "register not susscess";
	}

	public String verifyOTP(String email, String otp) {
		User user = iUserRepository.findByEmail(email);
		if (user == null) {
			return "user not find";
		}
		if (user.getOtp().equals(otp)
				&& Duration.between(user.getDateTime(), LocalDateTime.now()).getSeconds() < (1 * 60)) {
			user.setStatus(true);
			iUserRepository.save(user);
			return "email verify success";
		} else {
			return "het thoi gian";
		}
	}

	public String createdOTP(String email) {
		User user = iUserRepository.findByEmail(email);
		if (user == null) {
			return "user not find";
		}
		String otp = generateOTP.createOTP();
		try {
			mailUtil.sendMail(email, otp);
			user.setOtp(otp);
			user.setDateTime(LocalDateTime.now());
			iUserRepository.save(user);
			return "refresh otp success";

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "refresh not otp";
	}
	
	public String forgotPass() {
		
		
		return "";
	}

}
