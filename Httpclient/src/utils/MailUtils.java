package utils;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class MailUtils {
	
	public static void sendMail(String to, HashMap hq) throws Exception{
		
		Properties props = new Properties();
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@qq.com","123");
			}
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("service@qq.com"));
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		message.setSubject("你相中股票涨啦！！！不买不是人！！！！！！！");
		message.setContent("<h1>格力电器</h1><br/><h3>实时股价:"+hq.get("name")+"@"+hq.get("time")+
				":"+hq.get("price")+""+"#涨幅:+"+hq.get("increase")+"</h3>" , 
				"text/html;charset=utf-8");
		Transport.send(message);
		
		
	}
}
