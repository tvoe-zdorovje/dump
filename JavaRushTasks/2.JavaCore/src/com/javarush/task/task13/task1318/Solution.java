package com.javarush.task.task13.task1318;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream stream = null;
		try {
			stream = new FileInputStream(reader.readLine());
			String s = "";
			while (stream.available() > 0) {
				System.out.print((char)stream.read());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			reader.close();
			stream.close();
		}
	}
}