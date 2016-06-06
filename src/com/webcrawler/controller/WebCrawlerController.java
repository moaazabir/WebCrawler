package com.webcrawler.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.inject.Inject;
import com.webcrawler.app.CrawlerPort;
import com.webcrawler.app.LoggerPort;
import com.webcrawler.app.RepositoryPort;
import com.webcrawler.app.WebCrawlerUseCase;

public class WebCrawlerController implements LoggerPort,CrawlerPort,RepositoryPort {
	
	
	private RepositoryService repositoryService;
	
	private CrawlService crawlService;
	
	@Inject
	public void setRepositoryService(RepositoryService pRepositoryService) {
		this.repositoryService = pRepositoryService;
	}
	
	@Inject
	public void setCrawlService(CrawlService pCrawlService){
		this.crawlService = pCrawlService;
	}
	
	
	public void execute(String baseUrl){
		
		new WebCrawlerUseCase(this,this,this).startCrawler(baseUrl);
	}
	
	public void execute(String baseUrl,Integer linksToBeSearched){
		
		new WebCrawlerUseCase(this,this,this).startCrawler(baseUrl,linksToBeSearched);
	}


	@Override
	public void info(String tag, String message) {
		System.out.println(String.format("[%s] %s", tag,message));
		
	}

	@Override
	public void error(String tag, String message) {
		System.err.println(String.format("[%s] %s", tag,message));
	}

	@Override
	public void addToRepository(Integer searchDepth, List<String> links) {
		repositoryService.add(searchDepth,links);
		
	}

	@Override
	public List<String> crawl(String url) {
		try {
			return crawlService.crawl(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<String>();
	}

	@Override
	public List<String> fetchFromRepository(Integer depthLevel) {
		return repositoryService.fetch(depthLevel);
	}
	
	

}
