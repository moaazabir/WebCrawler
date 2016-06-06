package com.webcrawler.dao;

import java.util.ArrayList;

public class WebUrl {
	
	String baseUrl ;
	
	ArrayList<String> linksOnPage;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public ArrayList<String> getLinksOnPage() {
		return linksOnPage;
	}

	public void setLinksOnPage(ArrayList<String> linksOnPage) {
		this.linksOnPage = linksOnPage;
	}
	
}
