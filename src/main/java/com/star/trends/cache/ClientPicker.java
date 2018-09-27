package com.star.trends.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.star.trends.client.EbayClient;
import com.star.trends.client.StockTwitsClient;
import com.star.trends.client.TwitterClient;
import com.star.trends.client.WalmartClient;
import com.star.trends.client.YoutubeClient;
import com.star.trends.model.Trends;

public class ClientPicker {
	@Autowired
	private TwitterClient twitterClient = new TwitterClient();
	
	@Autowired
	private StockTwitsClient stockTwitsClient = new StockTwitsClient();
	
	private WalmartClient walmartClient = new WalmartClient();
	
	private EbayClient ebayClient = new EbayClient();
	
	private YoutubeClient youtubeClient = new YoutubeClient();
	
	public Trends fetchTrendsClient(String clientName) {
		switch(clientName) {
		   case "twitter" :
		      return twitterClient.getTrendsFromLocation("canada");
		   
		   case "stocktwits" :
		      return stockTwitsClient.getTrendingSymbols();
		      
		   case "google" :
			  // Statements
			  break; // optional
		
		   case "youtube" :
			  return youtubeClient.getTopVideos("US", "10", "mostPopular");	      
		   
		   case "walmart" :
			  return walmartClient.getTrendingItems();
			
		   case "ebay" :
			  return ebayClient.getMostViewedItems();
			  
		   case "instagram" :
			  break;	  
				  
		   default : // Optional
		      // Statements
		}
		return null;
		
	}
	
	/*
	 * {
	"trends" : [{
		"type" : "Twitter",
		"logo" : "www.twitter.logo.com",
		"numOfTrends" : 10,
		"trend" : [{
			"title" : "Ebay twitter",
			"link" : "http://www.ebay.com",
			"image" : "if.any.com"
		},
		{
			"title" : "Elon Musk twitter",
			"link" : "http://www.ebamusky.com",
			"image" : "if.any.com"
		}]		
	},
	{
		"type" : "StockTwits",
		"logo" : "www.stocktwits.logo.com",
		"numOfTrends" : 10,
		"trend" : [{
			"title" : "Ebay twitter",
			"link" : "http://www.ebay.com",
			"image" : "if.any.com"
		},
		{
			"title" : "Elon Musk twitter",
			"link" : "http://www.ebamusky.com",
			"image" : "if.any.com"
		}]		
	}]
}
	 * 
	 * */
}
