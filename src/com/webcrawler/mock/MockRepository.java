package com.webcrawler.mock;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

import com.google.inject.Singleton;
import com.webcrawler.controller.RepositoryService;

@Singleton
public class MockRepository implements RepositoryService{
	
	TreeMap<Integer, List<String>> depthSearchMap;
	
	public MockRepository(){
		
	}
	

	@Override
	public void add(Integer iterationIndex, List<String> links) {
		System.out.println(String.format("iteration : %s . links added : %s", iterationIndex,links.size()));
		
	}


	@Override
	public Collection<List<String>> fetch() {
		return depthSearchMap.values();
	}


	@Override
	public List<String> fetch(Integer depth) {
		return depthSearchMap.get(depth);
	}
	

}
