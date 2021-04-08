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
	
	/*
	 *Test Email  addBcc(String... emails) function
	 * Coverage: 84.8%
	 */
	@Test
	public void testAddBcc() throws Exception {
		
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
		
	}
	
	/*
	 * Test Email addCc(String email) function
	 * Coverage: 100.0%
	 */
	@Test
	public void testAddCc() throws Exception {
		
		email.addCc("a@abc.com");
		
		assertEquals(1, email.getCcAddresses().size());
		
	}
	
	/*
	 * Test void addHeader(String name, String value) function
	 * Coverage: 100.0%
	 */
	@Test
	public void testAddHeader() throws Exception {
		
		email.addHeader("Test", "Test Header");
		
		assertEquals(1, email.getHeaders().size());
		
	}
	
	@Test
	public void testAddHeaderNullName() throws Exception {
		
		email.addHeader(null, "Test Header");
				
		assertEquals(0, email.getHeaders().size());
		
	}
	
	@Test
	public void testAddHeaderNullValue() throws Exception {
		
		email.addHeader("Test", null);
				
		assertEquals(0, email.getHeaders().size());
		
	}
	
	/*
	 * Test Email addReplyTo(String email, String name) function
	 * Coverage: 100.0%
	 */
	@Test
	public void testAddReplyTo() throws Exception {
		
		email.addReplyTo("a@abc.com", "Test Name");
		
		assertEquals(1, email.getReplyToAddresses().size());
		
	}
	
	/*
	 * Test void buildMimeMessage() function
	 * Coverage: 70.8%
	 */
	@Test
	public void testBuildMimeMessage() throws Exception {
		
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.setFrom("a@abc.com");
		email.addTo("a@abc.org");
		email.setSubject("Test");
		email.setCharset("ISO-8859-1");
		email.setContent("Test Content", "text/plain");
		email.addCc("a@abc.net");
		email.addBcc("a@abc.com");
		email.addHeader("Test", "Test Header");
		email.addReplyTo("a@abc.com", "A");
		email.setSentDate(new Date());
		
		email.buildMimeMessage();
		
	}
	
	@Test
	public void testBuildMimeMessageNullContent() throws Exception {
				
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.setFrom("a@abc.com");
		email.addTo("a@abc.org");
		email.setSubject("Test");
		email.setCharset("ISO-8859-1");
		email.setContent(null);
		email.addCc("a@abc.net");
		email.addBcc("a@abc.com");
		email.addHeader("Test", "Test Header");
		email.addReplyTo("a@abc.com", "A");
		email.setSentDate(new Date());
		
		email.buildMimeMessage();
		
	}
	
	@Test
	public void testBuildMimeMessageException() throws Exception {
		
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props);
		email.message=email.createMimeMessage(session);
		
		email.buildMimeMessage();
		
	}
	
	/*
	 * Test String getHostName() function
	 * Coverage: 70.6%
	 */
	@Test
	public void testGetHostName() throws Exception {
		
		email.setHostName("192.127.0.1");
		
		String hostname=email.getHostName();
		
		assertEquals("192.127.0.1", hostname);
		
	}
	
	@Test
	public void testGetHostNameNull() throws Exception {
		
		email.setHostName(null);
		
		String hostname=email.getHostName();
		
		assertEquals(null, hostname);
		
	}
	
	/*
	 * Test Session getMailSession() function
	 * Coverage: 90.9%
	 */
	@Test
	public void testGetMailSession() throws Exception {
		
		email.setHostName("local host");
		email.setAuthentication("userName", "password");
		email.setBounceAddress("a@abc.com");
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		email.setSSLCheckServerIdentity(true);
		
		email.getMailSession();
		
	}
	
	/*
	 * Test Date getSentDate() function
	 * Coverage: 100.0%
	 */
	@Test
	public void testGetSentDate() throws Exception {
		
		Date now = new Date();
		email.setSentDate(now);
		
		Date date=email.getSentDate();
		
		assertEquals(now, date);
		
	}