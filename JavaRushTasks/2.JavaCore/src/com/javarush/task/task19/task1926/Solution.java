package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		reader.close();
		reader = new BufferedReader(new FileReader(str));

		while ((str = reader.readLine()) != null) {
			StringBuilder builder = new StringBuilder(str);
			System.out.println(builder.reverse().toString());
		}
		reader.close();
	}
}
