package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String url = reader.readLine();
		reader.close();

		String[] params = url.substring(url.indexOf('?')+1).trim().split("&");
        String obj = "";

	    for (int i = 0; i < params.length; i++) {

		    if (params[i].contains("=")){
			    if (params[i].contains("obj")) obj = params[i].substring(params[i].indexOf('=')+1);
			    params[i] = params[i].substring(0, params[i].indexOf('='));
		    }
		    System.out.println(params[i]);
	    }

//		String param;
//		String obj = "";
//		Pattern p = Pattern.compile("\\?.*?&|&.*?&|&.*?$");
//		Matcher m = p.matcher(url.replaceAll("&", "&&"));
//
//		while (m.find()) {
//
//			if ((param = m.group().substring(1, m.group().length() - 1)).contains("=")) { //если есть "=", то
//				if (param.contains("obj")) {                        // если это "obj", то
//					obj = param.substring(param.indexOf('=') + 1);      //записываем значение
//				}
//				param = param.substring(0, param.indexOf('='));     //отсекаем лишнее
//			}
//			System.out.println(param);
//		}

		if (!obj.equals("")) {
			char ch[] = obj.toCharArray();
			boolean isDigit = true;
			for (char c : ch) {
				if (c != '.' && c != '-' && !Character.isDigit(c)) isDigit = false;
			}
			if (isDigit) alert(Double.parseDouble(obj));
			else alert(obj);
		}

	}

	public static void alert(double value) {
		System.out.println("double: " + value);
	}

	public static void alert(String value) {
		System.out.println("String: " + value);
	}
}
