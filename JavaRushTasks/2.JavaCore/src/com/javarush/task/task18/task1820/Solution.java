package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String name1 = reader.readLine();
	    String name2 = reader.readLine();
reader.close();

	    FileInputStream inFile1 = new FileInputStream(name1);
	    FileOutputStream outFile2 = new FileOutputStream(name2);

	    String str = "";

	    while (inFile1.available() >0){
	    	str+=(char)inFile1.read();
	    }
	    inFile1.close();

	    String[] digitsStr = str.split(" ");

	    for (String s : digitsStr) {
		    outFile2.write((Long.toString(Math.round(Double.parseDouble(s)))+" ").getBytes());
	    }



	    outFile2.flush();
	    outFile2.close();
    }
}
