package org.apache.commons.mail;

import java.util.Map;

public class EmailConcrete extends Email {

	@Override
	public Email setMsg(String msg) throws EmailException {
		
		return null;
		
	}
	
	/*
	 * Return headers function
	 */
	
	public Map<String, String> getHeaders() {
		return this.headers;
	}
	
}
