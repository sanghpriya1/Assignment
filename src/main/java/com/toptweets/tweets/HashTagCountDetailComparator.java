package com.toptweets.tweets;

import java.util.Comparator;

public class HashTagCountDetailComparator implements Comparator<HashTagCountDetail> {

	@Override
	public int compare(HashTagCountDetail h1, HashTagCountDetail h2) {
		if (h1.getCount() > h2.getCount())
			return 1;
		else if (h1.getCount() < h2.getCount())
			return -1;
		return 0;
	}
}
