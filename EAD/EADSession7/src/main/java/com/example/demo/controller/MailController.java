package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MailSender;

@RestController
public class MailController 
{
	
	/* name injection
	 * @Autowired
	 * 
	 * @Qualifier("mockmail")
	 */  
	private MailSender mailSender;
	
	
	
	/*constructor injection
	 * @Autowired
	 * 
	 * public MailController(MailSender mailSender) { this.mailSender=mailSender; }
	 */
	
	
	/* setter injection
	 * @Autowired
	 * 
	 * @Qualifier("mockmail") public void setMailsender(MailSender mailSender) {
	 * this.mailSender=mailSender; }
	 */
	 
		
	  /**
	   * constructor injection using config class
	   * @param mockmail
	   */
	  @Autowired 
	  public MailController(MailSender mockmail) 
	  {
		  mailSender=mockmail;
	  
	  }
	 
	
	
	
	@GetMapping("/mail1")
	public String send()
	{
		mailSender.send();
		return "success";
	}

}
