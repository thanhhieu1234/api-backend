package com.example.demo.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.utils.GenerateOTP;

@Component
public class MailUtil {

	@Autowired
	JavaMailSender mailSender;

	
	public void sendMail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setTo(email);
		helper.setSubject("Verify OTP");
		helper.setText("Mã OTP của bạn là " + otp);
		mailSender.send(mimeMessage);
	}
}
