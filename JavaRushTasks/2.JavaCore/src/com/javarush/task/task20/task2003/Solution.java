package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
	public static Map<String, String> properties = new HashMap<>();

	public void fillInPropertiesMap() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FileInputStream inputStream = new FileInputStream(reader.readLine());
		reader.close();
		load(inputStream);
		inputStream.close();
	}

	public void save(OutputStream outputStream) throws Exception {
		Properties prop = new Properties();
		prop.putAll(properties);
		prop.store(outputStream, null);
		outputStream.flush();
	}

	public void load(InputStream inputStream) throws Exception {
		Properties prop = new Properties();
		prop.load(inputStream);
		properties.putAll((Map) prop);
	}

	public static void main(String[] args) throws Exception {
//		properties.put("pone", "1");
//		properties.put("pthreeone", "13");
//		properties.put("пять", "13");
//		new Solution().save(new FileOutputStream("file.properties"));
//		properties.clear();
//		System.out.println(properties);
//		Solution s = new Solution();
//		s.fillInPropertiesMap();
//		System.out.println(properties);
	}
}
