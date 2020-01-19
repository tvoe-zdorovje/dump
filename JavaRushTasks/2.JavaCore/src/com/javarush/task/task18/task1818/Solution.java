package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String name1 = reader.readLine();
	    String name2 = reader.readLine();
	    String name3 = reader.readLine();
	    reader.close();

	    FileOutputStream outFile1 = new FileOutputStream(name1);
	    FileInputStream inFile2 = new FileInputStream(name2);
	    FileInputStream inFile3 = new FileInputStream(name3);

	    while (inFile2.available() > 0){
	    	outFile1.write(inFile2.read());
	    }
	    inFile2.close();
	    outFile1.flush();
	    outFile1.close();
	    outFile1 = new FileOutputStream(name1, true);

	    while (inFile3.available() >0){
	    	outFile1.write(inFile3.read());
	    }
	    inFile3.close();
	    outFile1.flush();
	    outFile1.close();


    }
}
