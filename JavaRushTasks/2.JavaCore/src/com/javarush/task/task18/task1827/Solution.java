package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {


			//open file
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String s = reader.readLine();
			reader.close();

		if (args.length != 0 && args[0].equals("-c")) {

			//read data
			int maxID = 0;
			String str;

			reader = new BufferedReader(new FileReader(s));

			while ((str = reader.readLine()) != null) {
				if (!str.equals("")) maxID = Math.max(Integer.parseInt(str.substring(0, 8).trim()), maxID);
			}
			reader.close();


			//write new product
			str = String.format("\n%-8d%-30.30s%-8.2f%-4d", (maxID+1), args[1], Double.parseDouble(args[2]), Integer.parseInt(args[3]));

			BufferedWriter writer = new BufferedWriter(new FileWriter(s, true));
			writer.write(str);
			writer.flush();
			writer.close();


			//System.out.println("19847983Куртка для сноубордистов, разм10173.991234".substring(38,46));
		}
	}
}
