/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 8:33:18 AM
 */
package com.softserve.kutsepalov.app;

/**
 * @author Max Kutsepalov
 *
 */
public class Order implements Comparable<Order>{
    private int price;
    private OrderType type;
    
    /**
     * @param price
     * @param type
     */
    public Order(int price, OrderType type) {
	this.price = price;
	this.type = type;
    }
    
    @Override
    public int compareTo(Order o) {
	int res = o.price - this.price;
	if(res == 0) {
	    if(this.type == o.type) {
		res = 0;
	    } else if(this.type == OrderType.BID) {
		res = 1;
	    } else if(this.type == OrderType.ASK) {
		res = -1;
	    }
	}
	return res;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + price;
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Order)) {
	    return false;
	}
	Order other = (Order) obj;
	if (price != other.price || type != other.type) {
	    return false;
	}
	if (type != other.type) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("[");
	builder.append(price);
	builder.append(" : ");
	builder.append(type);
	builder.append("]");
	return builder.toString();
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @return the type
     */
    public OrderType getType() {
        return type;
    }
    /**
     * @param price the price to set
     */
    protected void setPrice(int price) {
        this.price = price;
    }
    /**
     * @param type the type to set
     */
    protected void setType(OrderType type) {
        this.type = type;
    }

}
