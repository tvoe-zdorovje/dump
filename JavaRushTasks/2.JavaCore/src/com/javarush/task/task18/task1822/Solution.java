package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
	    reader.close();

	    int id = Integer.parseInt(args[0]);

	    String str = "";
	    while ((str = fileReader.readLine()) != null){
	    	if (str.startsWith(id+" ")) {
	    		//str = str.substring(str.indexOf(' ')+1);
	    		break;
		    }
	    }
	    fileReader.close();

//	    String name = null, price = null, count = null;
//
//	    Pattern p = Pattern.compile("\\D+\\s|\\s\\d*\\.\\d*\\s");
//	    Matcher m = p.matcher(str);
//
//	    while (m.find()) {
//		    name = m.group().trim();
//	    }
//
//	    p = Pattern.compile("\\s\\d*\\.\\d*\\s");
//	    m = p.matcher(str);
//
//	    while (m.find()){
//		    price = m.group().trim();
//	    }
//
//	    count = str.substring(str.lastIndexOf(' ')+1);
//
//
//	    System.out.println(String.join(" ", name, price, count));
	    System.out.println(str);
    }
}
