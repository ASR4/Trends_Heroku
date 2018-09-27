package com.star.trends.trending;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.star.trends.model.TrendResponse;
import com.star.trends.service.TrendsService;

@RestController
public class TrendsController {
	
	private TrendsService trendsService = new TrendsService();
	
	@RequestMapping("/fetch/{trend}")
    public TrendResponse fetchTrend (@PathVariable("trend") String clientName) {
    	 return trendsService.fetchListOfTrends(clientName);
    }
    
	@RequestMapping(value="/fetchall", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public TrendResponse fetchTrendAll () {
    	 return trendsService.fetchAll();
    }
    
}
