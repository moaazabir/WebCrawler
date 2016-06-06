package com.config;

import com.google.inject.AbstractModule;
import com.webcrawler.controller.CrawlService;
import com.webcrawler.controller.RepositoryService;
import com.webcrawler.mock.MockRepository;
import com.webcrawler.util.CrawlServiceImpl;

public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
		bind(RepositoryService.class).to(MockRepository.class);
		bind(CrawlService.class).to(CrawlServiceImpl.class);
		
	}

}
