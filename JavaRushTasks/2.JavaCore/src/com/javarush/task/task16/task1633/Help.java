package com.javarush.task.task16.task1633;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Help {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//add your code here
		String str = reader.readLine();

		ArrayList<String> mass = new ArrayList<String>();

		String strSh = str.substring(str.lastIndexOf("?") + 1); // удаляем все до символа ?, оставляем obj=3.14&name=Amigo

		String strObj = strSh.split("&")[0]; // удаляем все после символа &, оставляем obj=3.14
		String lvl = strSh.split("=")[0]; // удаляем все после символа =, оставляем obj
		String strNum = strObj.substring(strObj.lastIndexOf("=") + 1); // удаляем все до символа =, оставляем 3.14
		mass.add(lvl);

		Pattern patternView = Pattern.compile("&.+&");
		Matcher matcherView = patternView.matcher(str);
		while (matcherView.find()) {
			String view = str.substring(matcherView.start() + 1, matcherView.end() - 1);
			mass.add(view);
		}

		String strName2 = strSh.substring(strSh.lastIndexOf("&") + 1); // удаляем все после символа =, оставляем name
		String strName = strName2.split("=")[0]; // удаляем все после символа =, оставляем name

		mass.add(strName);
		String listString = String.join(" ", mass);
		System.out.println(mass);

		try {
			if (strNum.contains(".")) {
				double d = Double.parseDouble(strNum);
				alert(d);


			} else if (!strNum.contains(".")) {
				int i = Integer.parseInt(strNum);
				double d = i;
				//alert(listString);
				alert(d);

			}

		} catch (Exception e) {
			alert(listString);
		}
	}

	public static void alert(double value) {
		System.out.println("double: " + value);
	}

	public static void alert(String value) {
		System.out.println("String: " + value);
	}
}
