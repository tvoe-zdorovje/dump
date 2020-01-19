package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

		String str;
		String out = "";
		while ((str = reader.readLine()) != null) {

			String[] arr = str.split(" ");
			for (String s : arr) {
				if (s.length()>6) out = String.join(",", out, s);
			}

		}

		out = out.replaceFirst(",", "");

		writer.write(out);

		reader.close();
		writer.close();
	}
}
