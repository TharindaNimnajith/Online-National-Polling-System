package com.onps.util;

import java.io.UnsupportedEncodingException;

import java.util.Date;
  
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This is the Email utility class
 * 
 * @see #CommonUtil
 */
public class EmailUtil extends CommonUtil {
	public static void sendEmail(String host, String port, final String senderEmail, String senderName, final String password,
     String recipientEmail, String subject, String message) throws AddressException, MessagingException, UnsupportedEncodingException {
  
        // sets SMTP server properties
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
  
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        };
  
        Session session = Session.getInstance(properties, auth);
  
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
  
        msg.setFrom(new InternetAddress(senderEmail, senderName));
        
        InternetAddress[] toAddresses = { 
        	new InternetAddress(recipientEmail) 
        };
        
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
  
        // sends the e-mail
        Transport.send(msg);
    }
}
