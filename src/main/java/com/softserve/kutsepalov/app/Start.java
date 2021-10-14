/**
 * Copyright 2021
 *
 * All rights reserved.
 *
 * Created on Oct 9, 2021 7:25:19 AM
 */
package com.softserve.kutsepalov.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Max Kutsepalov
 *
 */
public class Start {

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
	Controller controller = new Controller(
		new BufferedWriter(
			new FileWriter("output.txt")));
	
	try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
	    String line = reader.readLine();
	    while (line != null) {
		controller.execute(line);
		line = reader.readLine();
	    }
	}
	controller.close();
    }
}
