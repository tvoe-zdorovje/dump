package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(reader.readLine());
		int b = Integer.parseInt(reader.readLine());

		if (a <= 0 || b <= 0) throw new Exception();

			System.out.println(GCD(a, b));
	}

	public static int GCD(int a, int b) {
		if (b == 0) return Math.abs(a);
		return GCD(b, a % b);
	}
}
