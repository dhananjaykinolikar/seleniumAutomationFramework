package utils;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailUtils {
	public static void sendTestReport(String reportPath) {
		final String senderEmail = "bhushank10b@gmail.com";
		final String appPassword = "nbmtbwdlxwgmvzbp";
		final String receipientEmail = "bhushank10b@gmail.com";

		// SMTP server properties
		Properties prop = new Properties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		// create session
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}
		});
		session.setDebug(true);
		try {
			// create email message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipientEmail));
			message.setSubject("Test Email from java with attach");
			// message.setText("Hello\n This mail from Java \n Regards \n QA Team");

			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello\n This mail from Java \n Regards \n QA Team");

			// Attachmnet part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			//String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			attachmentPart.attachFile(new File(reportPath));

			// Combine email body and attachment
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);

			// Send Email
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
