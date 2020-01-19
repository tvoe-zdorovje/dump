package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		String cin;
		while (!(cin = reader.readLine()).equals("end")) {
			list.add(cin);
		}
		reader.close();

		cin = list.get(0);

		FileOutputStream outputStream = new FileOutputStream(cin.substring(0, cin.lastIndexOf(".part")));
		FileInputStream inputStream;
		byte[] buffer = new byte[1024];
		for (int i = 0; i <= list.size(); i++) {
			for (String s : list) {

				if (s.endsWith("part" + i)) {
					inputStream = new FileInputStream(s);

					while (inputStream.available()>0){
						int count = inputStream.read(buffer);
						outputStream.write(buffer, 0, count);
					}

					inputStream.close();
					outputStream.flush();
				}
			}
		}

		outputStream.close();
	}
}
