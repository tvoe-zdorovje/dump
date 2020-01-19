package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
	    SortedMap<String, Double> map = new TreeMap<>();
	    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	    String str;
	    while ((str = reader.readLine())!=null && !str.equals("")) {
		    String key = str.split(" ")[0];
		    Double value = Double.parseDouble(str.split(" ")[1]);
		    if (map.containsKey(key)) value += map.get(key);
		    map.put(key, value);
	    }
	    reader.close();

	    for (Map.Entry<String, Double> entry : map.entrySet()) {
		    System.out.println(entry.getKey() + " " + entry.getValue());
	    }


    }
}
