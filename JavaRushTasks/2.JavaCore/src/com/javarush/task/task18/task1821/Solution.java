package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {

    	int[] bytes = new int[255];
	    Arrays.fill(bytes, 0);
	    FileInputStream inputStream = new FileInputStream(args[0]);
	    while (inputStream.available()>0){
	    	bytes[inputStream.read()]++;
	    }

	    for (int i = 0; i < bytes.length; i++) {
		    if (bytes[i] != 0) System.out.println((char)i + " " + bytes[i]);
	    }

	    inputStream.close();
    }
}
