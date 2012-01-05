package com.dimitrisli.springEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

	@Autowired
	private MailSender emailSender;
	@Autowired
	private SimpleMailMessage exceptionEmail;
	
	public void sendEmail(String from, String to, String subj, String body){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subj);
		message.setText(body);
		emailSender.send(message);
	}
	
	public void sendExceptionEmail(String error){
		SimpleMailMessage exceptionEmailMessage = new SimpleMailMessage(exceptionEmail);
		exceptionEmailMessage.setText(error);
		emailSender.send(exceptionEmailMessage);
	}
}
