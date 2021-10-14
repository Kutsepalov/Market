/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 9:44:44 AM
 */
package com.softserve.kutsepalov.app;

import static java.lang.Integer.parseInt;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * @author Max Kutsepalov
 *
 */
public class Controller {
    private Book book = new Book();
    private BufferedWriter wr;
    private boolean isFirstLine = true;

    public Controller(BufferedWriter wr) {
	this.wr = wr;
    }

    public void execute(String command) {
	if (command.charAt(0) == 'u') {
	    update(command.substring(2));
	} else if (command.charAt(0) == 'q') {
	    query(command.substring(2));
	} else {
	    order(command.substring(2));
	}
    }

    private void update(String command) {
	String[] values = command.split(",");
	book.add(parseInt(values[0]), parseInt(values[1]), OrderType.get(values[2]));
    }

    private void query(String command) {
	String[] values = command.split(",");
	String res;
	if (values[0].equals("size")) {
	    res = String.valueOf(book.getSize(parseInt(values[1])));
	} else {
	    res = book.bestToString(OrderType.get(values[0].substring(5)));
	}
	try {
	    if (!isFirstLine) {
		wr.write("\n" + res);
	    } else {
		wr.write(res);
		isFirstLine = false;
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    private void order(String command) {
	String[] values = command.split(",");
	if (values[0].equals("buy")) {
	    book.buy(parseInt(values[1]));
	} else {
	    book.sell(parseInt(values[1]));
	}
    }

    public void close() throws IOException {
	wr.close();
    }
}
