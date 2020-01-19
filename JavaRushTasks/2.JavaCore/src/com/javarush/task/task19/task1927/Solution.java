package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

    	PrintStream orig = System.out;

	    ByteArrayOutputStream out = new ByteArrayOutputStream();

	    PrintStream stream = new PrintStream(out);
	    MyPrintStream my = new MyPrintStream(stream);

	    System.setOut(my);
		testString.printSomething();
		System.setOut(orig);
		my.close();

	    System.out.println(out);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

}
