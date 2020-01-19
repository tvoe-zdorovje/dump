package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
	public static void main(String[] args) throws IOException {
		FileInputStream inputFile = new FileInputStream(args[0]);

		int b;
		int count = 0;
		while (inputFile.available()>0){
			b = inputFile.read();
			if ((b >= 65 && b<=90) || (b>=97 && b<= 122)) {
				count++;
				//System.out.println(b);
				//System.out.printf("%d %c\n", b, (char)b);
			}
		}
		inputFile.close();
		System.out.println(count);


	}
}
