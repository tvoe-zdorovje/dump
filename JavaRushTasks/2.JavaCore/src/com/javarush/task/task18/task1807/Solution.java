package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileInputStream file = new FileInputStream(reader.readLine());
	    reader.close();


	    byte[] buffer = new byte[file.available()];
	    	file.read(buffer);
	    file.close();


	    int count = 0;
	    for (byte b : buffer) {
		    count += b==44 ? 1 : 0;
	    }
	    System.out.println(count);
    }
}
