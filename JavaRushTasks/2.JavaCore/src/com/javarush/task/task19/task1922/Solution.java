package com.javarush.task.task19.task1922;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {

	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String filename = reader.readLine();
	    reader.close();
	    reader = new BufferedReader(new FileReader(filename));

	    String str;
	    StringBuilder regex = new StringBuilder();

	    for (String word : words) {
		    regex.append("\\b").append(word).append("\\b|");
	    }

	    regex.deleteCharAt(regex.lastIndexOf("|"));
	    //System.out.println(regex);

	    while ((str = reader.readLine()) != null){
		    Pattern pattern = Pattern.compile(regex.toString());
		    Matcher matcher = pattern.matcher(str);

		    int count = 0;
		    while (matcher.find()){
			    count++;
		    }

		    if (count == 2) System.out.println(str);

	    }

	    reader.close();

    }
}
