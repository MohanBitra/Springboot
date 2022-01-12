package com.test.springboottest.springrestful;

import java.util.Date;

public class ExceptionResponse {
	
	private String timestamp;
	private Date date;
	private String details;
	
		
	public ExceptionResponse() {
		//super();
	}
	public ExceptionResponse(Date date, String timestamp, String details) {
		super();
		this.timestamp = timestamp;
		this.date = date;
		this.details = details;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public Date getDate() {
		return date;
	}
	public String getDetails() {
		return details;
	}
	
	
	

}
