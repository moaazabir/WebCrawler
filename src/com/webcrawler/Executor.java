package com.webcrawler;

import com.config.AppInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.webcrawler.controller.WebCrawlerController;

public class Executor{

	public static void main(String [] args){
		
		Injector injector = Guice.createInjector(new AppInjector());
		WebCrawlerController webCrawlerController = injector.getInstance(WebCrawlerController.class);
		webCrawlerController.execute("http://www.python.org",10);
	}

}
