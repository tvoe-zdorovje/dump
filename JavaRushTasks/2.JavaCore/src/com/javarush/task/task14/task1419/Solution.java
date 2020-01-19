package com.javarush.task.task14.task1419;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

	    System.out.println(15%20);

//        for (Exception exception : exceptions) {
//            System.out.println(exception);
//        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new IOException());
        exceptions.add(new NullPointerException());
        exceptions.add(new RuntimeException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new IndexOutOfBoundsException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassNotFoundException());

    }
}
