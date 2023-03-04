package com.amazin.nayra.common;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
	@Autowired(required = false)
	public JavaMailSender emailSender;
	
	public void sendSimpleMessage(String to, String subject,String text) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper msg = new MimeMessageHelper(message, true);
			msg.setFrom("vivek.rajak@amzbizsol.in");
			msg.setTo(to);
			//message.setContent(aa.toString(), "text/html");
			message.setSubject(subject);
			//message.addRecipient(RecipientType.CC, new InternetAddress( string));
			emailSender.send(message);
			//lOGGER.info("Deliver mail to======"+to);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public void sendEscalationMessage(String to, String subject, String text) {
		text = text + "\n\n Thank You,\n\nAmazin Team.";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("no.reply@in.fcm.travel");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
		LOGGER.info("Deliver Mail to: " + to);
	}


}
