package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	    BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
	    String str;
	    while ((str=reader.readLine())!=null){

	    	String[] strings = str.split(" ");

		    for (String string : strings) {
			    if (!string.equals(string.replaceAll("\\d", "")))
			    	writer.write(string+" ");
		    }

	    }

	    reader.close();
	    writer.close();
    }
}
