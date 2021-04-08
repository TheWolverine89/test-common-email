package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = {"a@abc.com", "b@abc.net", "a@abc.org"};
	
	/* Concrete Email Class for testing */
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
		
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}