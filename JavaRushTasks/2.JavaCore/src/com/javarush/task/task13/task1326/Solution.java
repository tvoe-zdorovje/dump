package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Integer> list = new ArrayList<>(20);

	    FileInputStream file = new FileInputStream(reader.readLine());

	    String s = "";
	    char ch;
	    while(file.available() > 0)
	    {
	    	ch = (char) file.read();
	    	if (Character.isDigit(ch) || ch == '-') s += ch;
	    	else if (!s.equals("")){
	    		list.add(Integer.parseInt(s));
	    		s = "";
		    }
	    }

	   // System.out.println(list);

	    list.sort(Comparator.naturalOrder());
	    list.forEach(integer -> {
	    	if (integer%2 == 0) System.out.println(integer);
	    });

	    file.close();
    }
}
