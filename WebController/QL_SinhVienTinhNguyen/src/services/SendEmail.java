package services;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	
	public SendEmail() {
	}
	
	public static void sendEmail(String recipient, String message) {
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		java.util.Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");
		
		try {
			Session session = Session.getDefaultInstance(props,
					new Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(
									Properties.prop.getProperty("email-admin"),
									Properties.prop.getProperty("email-password"));
						}
					});

			// -- Create a new message --
			Message msg = new MimeMessage(session);

			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress("absdgst2016@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient, false));
			msg.setSubject("CTU: Mat khau dang nhap he thong QL Sinh vien Tinh nguyen");
			msg.setText(message);
			msg.setSentDate(new Date());
			Transport.send(msg);
			System.out.println("Message sent.");
		} catch (MessagingException e) {
			System.out.println("Error, cause: " + e);
		}
	}
}
