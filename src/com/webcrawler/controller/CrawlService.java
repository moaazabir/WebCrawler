package com.webcrawler.controller;

import java.io.IOException;
import java.util.List;

public interface CrawlService {
	
	public List<String> crawl(String url) throws IOException,Exception ;
	
	

}
