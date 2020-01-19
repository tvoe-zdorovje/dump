package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

	    String[] strings = array.toString().split(" ");
	    String str = array.toString();
	    switch (strings[1]){
		    case "+":
			    System.out.println(str + (Integer.parseInt(strings[0]) + Integer.parseInt(strings[2])));
		    	break;
		    case "-":
			    System.out.println(str + (Integer.parseInt(strings[0]) - Integer.parseInt(strings[2])));
		    	break;
		    case "*":
			    System.out.println(str + (Integer.parseInt(strings[0]) * Integer.parseInt(strings[2])));
		    	break;
	    }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

