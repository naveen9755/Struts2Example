package com.swift.example.mailer;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.swift.example.dto.Email;

public class Mailer {

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

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			javax.mail.Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(email.getTo()));
			message.setSubject(email.getSubject());
			// message.setText(email.getBody());
			message.setContent(email.getMessage(), "text/html");
			Transport.send(message);
			System.out.println("Done");

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
