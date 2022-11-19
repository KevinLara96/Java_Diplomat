package mx.unam.diplomado.email;

import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSendTest {

	public static void main(String[] args) {
		String to = "correoOrigen";
		String from = "correoDestino";
		String host = "smtp.gmail.com";

		// Get the session object
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//Session session = Session.getDefaultInstance(properties);

		Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("correoGmail", "passwordGenerado");
			}
 
		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("El titulo del mensaje");

			// Now set the actual message
			message.setText("El mensaje a enviar");

			System.out.println("enviando...");
			// Send message
			Transport.send(message);
			System.out.println("Mensaje enviado correctamente....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

	}

}
