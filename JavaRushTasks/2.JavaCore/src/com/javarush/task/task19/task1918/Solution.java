package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
//НЕ ПРОВЕРЕНО ВАЛИДАТОРОМ. ПРОЧТАЙ ЕЩЕ РАЗ УСЛОВИЕ И СРАВНИ С ВЫВОДОМ!!!!!!!!!!!!!!!!!!!!!!

	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileReader fileReader = new FileReader(reader.readLine());
	    reader.close();

	    StringBuilder stringBuilder = new StringBuilder();
	    while (fileReader.ready()){
	    	stringBuilder.append((char)fileReader.read());
	    }
	    fileReader.close();

	    Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
	    Elements el = document.select(args[0]);
	    el.forEach(System.out::println);


    }
}
