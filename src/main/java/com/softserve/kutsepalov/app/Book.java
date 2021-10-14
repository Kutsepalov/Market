/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 9:46:58 AM
 */
package com.softserve.kutsepalov.app;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * @author Max Kutsepalov
 *
 */
public class Book {
    private Map<Integer, Integer> asks = new TreeMap<>();
    private Map<Integer, Integer> bids = new TreeMap<>();

    public void add(int price, int size, OrderType type) {
	Map<Integer, Integer> map = getMapByType(type);
	if (size == 0) {
	    map.remove(price);
	} else {
	    map.put(price, size);
	}
    }

    public void sell(int size) {
	buyOrSell(size, OrderType.BID);
    }

    public void buy(int size) {
	buyOrSell(size, OrderType.ASK);
    }

    /**
     * @param value
     * @return
     */
    public int getSize(Integer value) {
	int res = 0;
	if (asks.containsKey(value)) {
	    res += asks.get(value);
	}
	if (bids.containsKey(value)) {
	    res -= bids.get(value);
	    res = Math.abs(res);
	}
	return res;
    }

    public String bestToString(OrderType type) {
	Entry<Integer, Integer> best = getBestOrderByType(type);
	return best.getKey() + "," + best.getValue();
    }

    private Entry<Integer, Integer> getBestOrderByType(OrderType type) {
	TreeMap<Integer, Integer> map = getMapByType(type);
	if(type == OrderType.ASK) {
	    return map.firstEntry();
	} else {
	    return map.lastEntry();
	}
    }

    private void buyOrSell(int size, OrderType type) {
	while (size != 0) {
	    Map<Integer, Integer> map = getMapByType(type);
	    Entry<Integer, Integer> best = getBestOrderByType(type);
	    int oldSize = best.getValue();
	    if (oldSize <= size) {
		size -= oldSize;
		map.remove(best.getKey());
	    } else {
		map.put(best.getKey(), best.getValue() - size);
		size = 0;
	    }
	}
    }
    
    private TreeMap<Integer, Integer> getMapByType(OrderType type) {
	TreeMap<Integer, Integer> map;
	if(type == OrderType.ASK) {
	    map = (TreeMap<Integer, Integer>) asks;
	} else {
	    map = (TreeMap<Integer, Integer>) bids;
	}
	return map;
    }
    
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Book ");
	builder.append("ASKs {");
	builder.append(asks);
	builder.append("} BIDs {");
	builder.append(bids);
	builder.append("}");
	return builder.toString();
    }
}
