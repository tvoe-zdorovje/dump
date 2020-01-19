package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
		private Scanner fileScanner;

	    public PersonScannerAdapter(Scanner fileScanner) {
		    this.fileScanner = fileScanner;
	    }

	    @Override
	    public Person read() throws IOException {
	    	String[] str = fileScanner.nextLine().split(" ");
	    	DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
	    	Person person = null;
		    try {
			     person = new Person(str[1], str[2], str[0], dateFormat.parse(String.join(" ", str[3], str[4], str[5])));
		    } catch (ParseException e) {
			    e.printStackTrace();
		    }

		    return person;
	    }

	    @Override
	    public void close() throws IOException {
			fileScanner.close();
	    }
    }
}
