package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Player and Dancer
*/

public class Solution {
    public static void main(String[] args) throws Exception {

    	Dancer dancer = new Dancer("name");
	    System.out.println(dancer.name);
	    System.out.println((byte)3654);

    }


    static class Person {
	    String name;

	    int age = 9;
	    static int sex = 4;

	    public Person(String name) {
		    this.name = name;
		    System.out.println(age + sex   );
	    }

    }

    static class Dancer extends Person  {

    	int age = 9;
    	static int sex = 4;

	    public Dancer(String name) {
		    super(name);
		    System.out.println(age + sex   );
	    }
    }
}
