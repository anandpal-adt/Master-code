package com.amazin.nayra.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.amazin.nayra.model.EmailDetails;


@Service
public class  EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private OTPService otpService;
	
	@Value("${spring.mail.username}")
	private String sender;
     


	public String sendSimpleMail(EmailDetails details) {


		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom(sender);
		mailMessage.setTo(details.getRecipient());
		mailMessage.setText("Verification code is: "+String.valueOf(otpService.generateOTP(sender)));
		mailMessage.setSubject("OTP Verification");
		javaMailSender.send(mailMessage);

		return "mail sent successfully";
	}

}



	