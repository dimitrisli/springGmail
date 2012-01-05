package com.dimitrisli.springEmail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainSpringContainer {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/spring.xml");
		EmailService emailService = (EmailService) context.getBean("emailService");
		emailService.sendEmail("from@email.com", "to@email.com", "test subject", "test body");
		emailService.sendExceptionEmail("something went terribly wrong");
	}
}
