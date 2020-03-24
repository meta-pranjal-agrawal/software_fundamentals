package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mockmail")
public class MockMailSender implements MailSender 
{

	@Override
	public void send() {
		System.out.println("mock mail sent");
		
	}

}
