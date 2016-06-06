package com.webcrawler.app;

import java.util.ArrayList;
import java.util.List;

public class WebCrawlerUseCase {
	
	private LoggerPort mLoggerPort;
	
	private RepositoryPort mRepositoryPort;
	
	private CrawlerPort mCrawlerPort;

	private final String TAG = this.getClass().getCanonicalName();
	
	private Integer ITERATION_COUNT = 0;
	
	private Integer LINKS_TO_BE_SEARCHED_COUNT = 0;
	
	public WebCrawlerUseCase(LoggerPort pLoggerPort, RepositoryPort pRepositoryPort, CrawlerPort pCrawlerPort){
		this.mLoggerPort = pLoggerPort;
		this.mRepositoryPort = pRepositoryPort;
		this.mCrawlerPort = pCrawlerPort;
	}
	
	public void startCrawler(String baseUrl){
		
		mLoggerPort.info(TAG, "executed :)");
		
		do{
			List<String> urlFetched = new ArrayList<>();
			urlFetched.add(baseUrl);
			
			this.searchLinks(urlFetched,-1);
			
		}while(true);
		
	}
	
	public void startCrawler(String baseUrl,int linksToSearch){
		
		
		
		if(!(linksToSearch <= 0 )){
			
			LINKS_TO_BE_SEARCHED_COUNT = linksToSearch;
			mLoggerPort.info(TAG, "executed :)");
			
			do{
				List<String> urlFetched = new ArrayList<>();
				urlFetched.add(baseUrl);
				
				this.searchLinks(urlFetched,linksToSearch);
				
				if(LINKS_TO_BE_SEARCHED_COUNT != null && LINKS_TO_BE_SEARCHED_COUNT <=0){
					break;
				}
				
			}while(true);
		}
		
		
		
	}
	
	private void searchLinks(List<String> urls, Integer linksToSearch){

		for(String nextUrl : urls){
			
			List<String> linksFound = mCrawlerPort.crawl(nextUrl);
			
			mLoggerPort.info(TAG, "links found = "+linksFound.size());
			
			mRepositoryPort.addToRepository( ITERATION_COUNT++ , linksFound);
			
			if(LINKS_TO_BE_SEARCHED_COUNT != null){
				
				LINKS_TO_BE_SEARCHED_COUNT--;
				
				if(LINKS_TO_BE_SEARCHED_COUNT <= 0){
					return;
				}
				
				mLoggerPort.info(TAG, "links searched = "+linksToSearch);
				
			}
			
			
			if(linksFound != null && !linksFound.isEmpty()){
				searchLinks(linksFound,LINKS_TO_BE_SEARCHED_COUNT);
			}
		}
	}
	
	

}
