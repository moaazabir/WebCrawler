package com.webcrawler.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcrawler.controller.CrawlService;

public class CrawlServiceImpl implements CrawlService {

	@Override
	public List<String>  crawl(String url) throws IOException,Exception {
		
		List<String> links = new ArrayList<String>();

		Connection connection = Jsoup.connect(url);
		Document htmlDocument = connection.get();
		
		Elements linksOnPage = htmlDocument.select("a[href]");
		
		Iterator<Element> elementIterator = linksOnPage.iterator();
		
		while (elementIterator.hasNext()) {
			Element element = elementIterator.next();
			links.add(element.absUrl("href"));
			System.out.println(element.absUrl("href"));
			
			
		}
		
		System.out.println(linksOnPage.size());
		
		return links;
	}
	
	

}
