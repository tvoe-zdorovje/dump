package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {

		List<FileInputStream> list = new ArrayList<>();
		String name = null;

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

			while (true) {
				name = reader.readLine();
				list.add(new FileInputStream(name));
			}
		} catch (FileNotFoundException e) {
			System.out.println(name);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			for (FileInputStream inputStream : list) {
				inputStream.close();
			}
		}

	}
}
