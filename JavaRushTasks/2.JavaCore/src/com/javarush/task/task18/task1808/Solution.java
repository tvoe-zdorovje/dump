package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String fileName1 = reader.readLine();
	    String fileName2 = reader.readLine();
	    String fileName3 = reader.readLine();
	    reader.close();


	    FileInputStream file1 = new FileInputStream(fileName1);
	    FileOutputStream file2 = new FileOutputStream(fileName2);
	    FileOutputStream file3 = new FileOutputStream(fileName3);


	    byte[] buffer = new byte[file1.available()];
	    int count = file1.read(buffer);
	    file1.close();

	    file2.write(buffer, 0, count-(count/2));
	    file2.close();

	    file3.write(buffer, count-(count/2), count-(count-count/2));
	    file3.close();
    }
}
