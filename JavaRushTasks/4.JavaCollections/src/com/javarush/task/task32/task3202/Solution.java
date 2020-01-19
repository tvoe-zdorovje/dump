package com.javarush.task.task32.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Objects;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\Users\\dr0sh\\OneDrive\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3210\\q"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {

	    StringWriter
		    writer = new StringWriter();
	    try {

		    while (is.available()>0) {
			    writer.append((char) is.read());
		    }
	    } catch (NullPointerException e) {

	    }

	    return writer;
    }
}