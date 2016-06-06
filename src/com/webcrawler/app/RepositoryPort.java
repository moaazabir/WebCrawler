package com.webcrawler.app;

import java.util.List;

public interface RepositoryPort {
	
	public void addToRepository(Integer searchDepth, List<String> links);
	
	public List<String> fetchFromRepository(Integer depthLevel);

}
