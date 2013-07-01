package com.swift.example.mailer;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.swift.example.dto.Email;

public class Mailer {

	private static final Logger logger = Logger.getLogger(Mailer.class.getName());
	
	public void sendMail(Email email) {
		if (email == null) {
			return;
		}
		final String username = "humanequationtest@gmail.com";
		final String password = "equation1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.debug", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			javax.mail.Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			message.setContent(email.getMessage(), "text/html");
			Transport.send(message);
			logger.info("Email Sent...");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
