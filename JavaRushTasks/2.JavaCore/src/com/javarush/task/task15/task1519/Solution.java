package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (!(s = reader.readLine()).equals("exit")) {
			boolean isDigit = true;
			char[] chars = s.toCharArray();
			for (char aChar : chars) {
				if (aChar != '.' & aChar != '-' & !Character.isDigit(aChar)) {
					isDigit = false;
					break;
				}
			}


				if (isDigit) {
					if (s.contains(".")) print(Double.parseDouble(s));
					else if (Double.parseDouble(s) > 0 && Double.parseDouble(s) < 128) print((Short.parseShort(s)));
					else if (Double.parseDouble(s) <= 0 || Double.parseDouble(s) >= 128) print(Integer.parseInt(s));
				}
			else print(s);
		}
	}

	public static void print(Double value) {
		System.out.println("Это тип Double, значение " + value);
	}

	public static void print(String value) {
		System.out.println("Это тип String, значение " + value);
	}

	public static void print(short value) {
		System.out.println("Это тип short, значение " + value);
	}

	public static void print(Integer value) {
		System.out.println("Это тип Integer, значение " + value);
	}
}
