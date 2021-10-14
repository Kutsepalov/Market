/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 12, 2021 3:58:16 PM
 */
package com.softserve.kutsepalov.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Max Kutsepalov
 *
 */
class MarketTest {
    private Controller c;
    private Output out = Output.getInstance();
    
    @BeforeEach
    void setUp() throws Exception {
	c = new Controller();
    }

    @Test
    @DisplayName("\"Get size\" command should be correct")
    void test1() {
	c.execute("u,20,5,bid");
	c.execute("u,21,10,bid");
	c.execute("u,22,15,bid");
	c.execute("u,10,5,ask");
	c.execute("u,9,10,ask");
	c.execute("u,8,15,ask");
	
	c.execute("q,size,20");
	c.execute("q,size,21");
	c.execute("q,size,22");
	c.execute("q,size,10");
	c.execute("q,size,9");
	c.execute("q,size,8");
	c.execute("q,size,888");
	
	assertEquals("5",out.pop());
	assertEquals("10",out.pop());
	assertEquals("15",out.pop());
	assertEquals("5",out.pop());
	assertEquals("10",out.pop());
	assertEquals("15",out.pop());
	assertEquals("0",out.pop());
    }
    
    @Test
    @DisplayName("\"sell\" command should change best Bid")
    void test2() {
	c.execute("u,20,5,bid");
	c.execute("u,21,10,bid");
	
	c.execute("o,sell,11");
	c.execute("q,best_bid");

	assertEquals("20,4",out.pop());
    }
    
    @Test
    @DisplayName("\"buy\" command should change best Ask")
    void test3() {
	c.execute("u,20,5,ask");
	c.execute("u,21,10,ask");
	
	c.execute("o,buy,11");
	c.execute("q,best_ask");

	assertEquals("21,4",out.pop());
    }
}
