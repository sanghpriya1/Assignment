package com.toptweets.tweets;

public class HashTagCountDetail {
	
	private String hasTag;
	private int count;
	
	public HashTagCountDetail(String hasTag, int count) {
		this.hasTag = hasTag;
		this.count = count;
	}
	
	public String getHasTag() {
		return hasTag;
	}
	
	public void setHasTag(String hasTag) {
		this.hasTag = hasTag;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
