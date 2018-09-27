package com.star.trends.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.star.trends.model.Trend;
import com.star.trends.model.Trends;
import com.star.trends.model.stocktwits.StockTwits;
import com.star.trends.model.stocktwits.Symbols;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockTwitsClient {
//	https://api.stocktwits.com/api/2/trending/symbols.json?access_token=<access_token>
	public Trends getTrendingSymbols() {
		String url = "https://api.stocktwits.com/api/2/trending/symbols.json";
		Trends trends = new Trends();

		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);

			HttpResponse response = client.execute(request);

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
//				System.out.println(line);
				result.append(line);
			}
			
			//Converting json to Stocktwits pojo and then to Trends pojo
			System.out.println("[DEBUG] : Inside stocktwits client for cache call");
//			System.out.println(jsonToPojo(result.toString()));
			StockTwits stockTwits = jsonToPojo(result.toString());
			List<Symbols> symbols = stockTwits.getSymbols();
			
			List<Trend> listOfTrend = new ArrayList<Trend>();
			for(Symbols symbol : symbols) {
				Trend trend = new Trend();
				trend.setTitle(symbol.getTitle());
				trend.setLink("https://stocktwits.com/symbol/" + symbol.getSymbol());
				trend.setImage(symbol.getSymbol());
				listOfTrend.add(trend);
			}
			
			trends.setLogo("Stocktwits_logo");
			trends.setNumOfTrends("10");
			trends.setTrend(listOfTrend.subList(0, 9));
			trends.setType("StockTwits");
			
			return trends;
		}
		catch(Exception e){
			//TODO
		}
		
		return trends;
	}
	
	private StockTwits jsonToPojo(String json) {
		ObjectMapper mapper = new ObjectMapper();
		
		StockTwits stockTwits = null;
		try {
			stockTwits = mapper.readValue(json, StockTwits.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(stockTwits);
		
		return stockTwits;
	}
	
	public static void main(String args[]) {
		StockTwitsClient stockTwitsClient = new StockTwitsClient();
		stockTwitsClient.getTrendingSymbols();
	}
}
