package com.toptweets.tweets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

@Service
public class TopTrendingHashTagService {

	private HashMap<String, Integer> hashTagsCounter;
	private PriorityQueue<HashTagCountDetail> topKHashTagsCounter;
	private List<String> topKTrendingHashTags;
	

	public List<String> getTopKTrendingHashTags(List<String> tweets, int topK) {
		hashTagsCounter = new HashMap<String, Integer>();
		topKHashTagsCounter = new PriorityQueue<HashTagCountDetail>(topK, new HashTagCountDetailComparator());
		for (int index = 0; index < tweets.size(); ++index) {
			int lastIndex = tweets.get(index).lastIndexOf('#');
			String hashtag = tweets.get(index).substring(lastIndex);
			if (!hashTagsCounter.containsKey(hashtag)) {
				hashTagsCounter.put(hashtag, 1);
			} else {
				hashTagsCounter.put(hashtag, hashTagsCounter.get(hashtag) + 1);
			}
		}
		for (Map.Entry<String, Integer> hashTagCount : hashTagsCounter.entrySet()) {
			topKHashTagsCounter.add(new HashTagCountDetail(hashTagCount.getKey(), hashTagCount.getValue()));
			if (topKHashTagsCounter.size() > topK) {
				topKHashTagsCounter.poll();
			}
		}
		topKTrendingHashTags = new ArrayList<>();
		while (!topKHashTagsCounter.isEmpty()) {
			topKTrendingHashTags.add(topKHashTagsCounter.poll().getHasTag());
		}
		Collections.reverse(topKTrendingHashTags);
		return topKTrendingHashTags;
	}	
}
