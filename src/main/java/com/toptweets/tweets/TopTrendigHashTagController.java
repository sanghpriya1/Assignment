package com.toptweets.tweets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")
public class TopTrendigHashTagController {
	
	@Autowired
	private TopTrendingHashTagService topTrendingHashTagService;
	@Autowired
	private LoadTweets loadTweets;
	
	
	@GetMapping("/topTenTrendingHashTags")
	public List<String> getTopTenTrendingHashTags() {
		return topTrendingHashTagService.getTopKTrendingHashTags(loadTweets.getListOfTweets(), 10);
	}
	
	@GetMapping("/topKTrendingHashTags/{topK}")
	public List<String> getTopKTrendingHashTags(@PathVariable Integer topK) {
		return topTrendingHashTagService.getTopKTrendingHashTags(loadTweets.getListOfTweets(), topK);
	}	
}
