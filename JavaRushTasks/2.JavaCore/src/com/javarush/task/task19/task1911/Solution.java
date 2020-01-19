package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    	PrintStream consoleStream = System.out;

	    ByteArrayOutputStream array = new ByteArrayOutputStream();
	    PrintStream stream = new PrintStream(array);
	    System.setOut(stream);

	    testString.printSomething();

	    System.setOut(consoleStream);
	    stream.close();

	    //StringBuilder builder = new StringBuilder(array.toString());
//	    builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
//
//	    for (int i = 1; i < builder.length(); i++) {
//		    if(builder.charAt(i-1) == ' ') builder.setCharAt(i, Character.toUpperCase(builder.charAt(i)));
//	    }



	    System.out.println(array.toString().toUpperCase());


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
