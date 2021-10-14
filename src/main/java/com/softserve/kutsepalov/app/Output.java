/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 4:17:36 PM
 */
package com.softserve.kutsepalov.app;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Max Kutsepalov
 *
 */
public class Output {
    private static Output instance = null;
    
    private Deque<String> list;
    
    private Output() {
	list = new LinkedList<>();
    }

    public static Output getInstance() {
	if(instance == null) {
	    instance = new Output();
	}
	return instance;
    }
    
    public void add(String e) {
	list.add(e);
    }
    
    public String pop() {
	return list.pop();
    }
    
    public boolean isEmpty() {
	return list.isEmpty();
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Output [");
	builder.append(list);
	builder.append("]");
	return builder.toString();
    }
}
