package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("smtp")
public class SMTPMail implements MailSender
{

	@Override
	public void send() 
	{
		System.out.println("SMTP mail sent");
	}

}
