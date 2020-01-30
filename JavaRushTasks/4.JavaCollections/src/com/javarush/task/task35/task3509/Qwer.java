package com.javarush.task.task35.task3509;

import java.util.ArrayList;

public class Qwer {


/*
Больше 10? Вы нам не подходите
*/


	public static void main(String[] args) throws Exception {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("роза");
		strings.add("лоза");
		strings.add("лира");
		strings = fix(strings);

		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static ArrayList<String> fix(ArrayList<String> strings) {
		for (String z: strings){
			if (z.contains("р") && !z.contains("л"))
				strings.remove(z);
			else if (z.contains("л") && !z.contains("р"))
				strings.add(z);
			else;
		}
		return strings;
	}

	}



