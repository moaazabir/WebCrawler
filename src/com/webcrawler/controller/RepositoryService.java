package com.webcrawler.controller;

import java.util.Collection;
import java.util.List;

public interface RepositoryService {
	
	public void add(Integer iterationIndex, List<String> links);
	
	public  Collection<List<String>>  fetch();
	
	public List<String> fetch(Integer depth);

}
