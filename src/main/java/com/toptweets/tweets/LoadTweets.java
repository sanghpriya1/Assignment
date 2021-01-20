package com.toptweets.tweets;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tweets")
public class LoadTweets {
		
	private List<String> listOfTweets;

	public List<String> getListOfTweets() {
		return listOfTweets;
	}

	public void setListOfTweets(List<String> listOfTweets) {
		this.listOfTweets = listOfTweets;
	}	
}
