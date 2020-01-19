package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.*;

import static java.util.Comparator.reverseOrder;

public class Solution {
    public static void main(String[] args) throws IOException {
	    SortedMap<String, Double> map = new TreeMap<>();
	    //BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
	    String str;
	    double maxValue=0;
	    while ((str = reader.readLine())!=null && !str.equals("")) {
		    String key = str.split(" ")[0];
		    Double value = Double.parseDouble(str.split(" ")[1]);
		    if (map.containsKey(key)) value += map.get(key);
		    map.put(key, value);
		    maxValue = Math.max(value, maxValue);
	    }
	    reader.close();



	    for (Map.Entry<String, Double> entry : map.entrySet()) {
		    if (entry.getValue() == maxValue) System.out.println(entry.getKey());
	    }
    }
}
