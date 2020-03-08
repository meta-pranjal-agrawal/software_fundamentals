package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.MailSender;
import com.example.demo.model.MockMailSender;
import com.example.demo.model.SMTPMail;


  @Configuration 
  public class AppConfig
  {
  
  @Bean("smtp") 
  public MailSender smtp() 
  {
	  return new SMTPMail(); 
  }
  
  @Bean("mockmail")
  public MailSender mockmail() 
  { 
	  return new MockMailSender();
  }
  
  }
 
