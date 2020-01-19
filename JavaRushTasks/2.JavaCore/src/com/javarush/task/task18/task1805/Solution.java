package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileInputStream file = new FileInputStream(reader.readLine());
	    reader.close();
	    Set<Integer> set = new TreeSet<>();
	    while (file.available() > 0) {
		    set.add(file.read());
	    }
	    file.close();
	    for (Integer integer : set) {
		    System.out.print(integer + " ");
	    }
    }
}
