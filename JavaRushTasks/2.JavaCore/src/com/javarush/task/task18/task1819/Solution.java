package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String name1 = reader.readLine();
	    String name2 = reader.readLine();

	    FileInputStream inFile1 = new FileInputStream(name1);
	    byte[] buffer = new byte[inFile1.available()];
	    inFile1.read(buffer);
	    inFile1.close();

	    FileOutputStream outFile1 = new FileOutputStream(name1);
	    FileInputStream inFile2 = new FileInputStream(name2);


	    while (inFile2.available() >0){
	    	outFile1.write(inFile2.read());
	    }
		outFile1.flush();
	    outFile1.write(buffer);
	    outFile1.flush();
	    outFile1.close();
	    inFile2.close();

    }
}
