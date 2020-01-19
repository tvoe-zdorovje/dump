package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<String> list = new ArrayList<>(50);
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())));
	    String s = new String();
	    while (!s.equals("exit"))
	    {
		    s = reader.readLine();
			list.add(s);
	    }

	    for (String s1 : list) {
		    writer.write(s1 + "\n");
	    }

	    writer.close();
	    reader.close();
    }
}
