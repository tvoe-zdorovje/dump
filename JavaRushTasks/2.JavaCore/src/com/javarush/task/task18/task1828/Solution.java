package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		//open file
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String filename = reader.readLine();
		reader.close();


		List<String> list = new ArrayList<>(100);
		String s;
		reader = new BufferedReader(new FileReader(filename));
		while ((s = reader.readLine()) != null) {
			list.add(s);
		}
		reader.close();


		switch (args[0]) {
			case "-u":
				update(list, Integer.parseInt(args[1]), args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4]));
				break;
			case "-d":
				delete(list, args[1]);
				break;
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		for (String s1 : list) {
			if (!s1.equals("NONE")){
				writer.write(s1);
				writer.newLine();
			}
		}
		writer.flush();
		writer.close();
	}

	public static void update(List<String> list, int id, String productName, double price, int quantity ){
		for (String s : list) {
			if (s.substring(0,8).trim().equals(Integer.toString(id))) list.set(list.indexOf(s), String.format("%-8d%-30.30s%-8.2f%-4d", id, productName, price, quantity));
		}
	}

	public static void delete(List<String> list, String id){


		for (String s : list) {
			if (s.substring(0,8).trim().equals(id)) list.set(list.indexOf(s), "NONE");
		}
	}

}
