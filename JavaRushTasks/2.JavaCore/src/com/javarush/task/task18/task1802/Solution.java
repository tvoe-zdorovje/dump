package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileInputStream file = new FileInputStream(reader.readLine());

	    List<Integer> list = new ArrayList<>(20);

	    while (file.available() > 0) {
		    list.add(file.read());
	    }

	    reader.close();
	    file.close();

	    System.out.println(Collections.min(list));
    }
}
