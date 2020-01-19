package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileInputStream file = new FileInputStream(reader.readLine());
	    reader.close();

	    List<Integer> list = new ArrayList<>(20);
		Integer[] dictionary = new Integer[255];
		Arrays.fill(dictionary, 0);

		int rbyte;
	    while (file.available() > 0) {
		    list.add(rbyte = file.read());
		    dictionary[rbyte]++;
	    }
	    file.close();

	    List<Integer> arr = Arrays.asList(dictionary);

		arr.forEach(i -> {
			if (i == 0) arr.set(arr.indexOf(i), 256);
		});
	    //System.out.println(arr);

	    rbyte = Collections.min(arr);
	    for (int i = 0; i < dictionary.length; i++) {
		    if (dictionary[i].equals(rbyte)) System.out.print(i + " ");
	    }

    }
}
