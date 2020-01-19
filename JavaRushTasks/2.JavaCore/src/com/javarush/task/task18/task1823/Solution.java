package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String filename;
	    Thread lastThread = null;
	    while (!(filename = reader.readLine()).equals("exit")) {
	    	lastThread = new ReadThread(filename);
	    	Thread.sleep(10);
	    	lastThread.start();
	    }
	    reader.close();

	    if (lastThread != null && !lastThread.isInterrupted()) lastThread.join();
	    Thread.sleep(2000);
    }

    public static class ReadThread extends Thread {
    	String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
	        this.fileName = fileName;
        }

	    @Override
	    public void run() {

        	int[] dictionary = new int[255];
		    try {

			    FileInputStream inputStream = new FileInputStream(fileName);

			    while (inputStream.available() > 0){
			    	dictionary[inputStream.read()]++;
			    }
			    inputStream.close();

			    int max = 0;
			    for (int i : dictionary) {
				    max = Math.max(max, i);
			    }

			    synchronized (resultMap) {
				    for (int i = 0; i < dictionary.length; i++) {
					    if (dictionary[i] == max) resultMap.put(fileName, i);
				    }
			    }

		    } catch (FileNotFoundException e) {
			    e.printStackTrace();
		    } catch (IOException e) {
			    e.printStackTrace();
		    }


	    }

	    // implement file reading here - реализуйте чтение из файла тут
    }
}
