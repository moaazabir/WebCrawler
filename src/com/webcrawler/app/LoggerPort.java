package com.webcrawler.app;
/**
 * Purpose of this interface is to log the output from the use case class
 * 
 * */
public interface LoggerPort {
	
	public void info(String tag, String message);
	
	public void error(String tag, String message);

}
