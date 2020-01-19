package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;
import java.net.URL;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String name = reader.readLine();
	    reader.close();


	    PrintStream consoleStream = System.out;

	    ByteArrayOutputStream array = new ByteArrayOutputStream();
	    PrintStream stream = new PrintStream(array);
	    System.setOut(stream);

	    testString.printSomething();

	    System.setOut(consoleStream);
	    stream.close();

	    FileOutputStream outputStream = new FileOutputStream(name);
	    System.out.println(array.toString());
	    outputStream.write(array.toByteArray());
	    outputStream.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

