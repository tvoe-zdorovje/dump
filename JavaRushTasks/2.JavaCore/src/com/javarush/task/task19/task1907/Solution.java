package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FileReader fileReader = new FileReader(reader.readLine());
		reader.close();

		int count = 0;
		String str = "";
		while (fileReader.ready()) {
			char c = (char) fileReader.read();
			str+=c;
		}
		fileReader.close();

		Pattern p = Pattern.compile("\\bworld\\b");
		Matcher matcher = p.matcher(str);

		while (matcher.find()){
			count++;
		}

		System.out.println(count);
	}
}
