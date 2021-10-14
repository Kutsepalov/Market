/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 8:34:53 AM
 */
package com.softserve.kutsepalov.app;

/**
 * @author Max Kutsepalov
 *
 */
public enum OrderType {
    BID,
    ASK;
    
    public static OrderType get(String value) {
	if(value.equals("bid")) {
	    return BID;
	} else if(value.equals("ask")) {
	    return ASK;
	}
	throw new IllegalArgumentException("No enum constant " + value);
    }
}
