package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

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

	    System.out.println(array.toString().replaceAll("te", "??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
