package ct.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ct.intit.Base;

public class Mail {
	
	public static void getMail() {
		String timeStamp = new  SimpleDateFormat("M/d/yyyy hh:mm:ss").format(new Date());
		StringBuilder mailBody = new StringBuilder();
		mailBody.append("<p>Hello Team,</p>    \r\n" + 
				"<p>This is to notify that automation process for Cost Transparency project has been <font color=52D118><strong>Completed.</strong></font>\r\n" + 
				"</p>\r\n" + 
				"<p>Please find the attached Cost transparency Report.</p> \r\n" + 
				"<p>&nbsp;</p>     \r\n" + 
				"<p>Thanks,</p>   \r\n" + 
				"<p>Team Automation</p>");
	
		final String username = "Dummy";
		final String password = "Dummy";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mailo2.uhc.com");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("dhanapal.a@optum.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Readconfig.getMailToRecipients()));
			
			message.setSubject("Cost Transparency Automation Report - "+timeStamp);
			
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("<html><font color = red>Red</font></html>");
			messageBodyPart1.setContent(mailBody.toString(), "text/html");
 		
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = "./test-output\\"+Base.reportname; // Mention the file which you want to send
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);
 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart2);
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			
			Transport.send(message);
			System.out.println("Mail Sent Successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	}


