package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
	    FileInputStream inputFile = new FileInputStream(args[0]);
	    int whitespaceCount = 0;
	    int otherCount = 0;
	    while (inputFile.available()>0){
	    	if (inputFile.read() == (byte)' ') whitespaceCount++;
	    	otherCount++;
	    }
	    inputFile.close();

	    System.out.printf("%.2f",(double)whitespaceCount/otherCount*100.0);
    }
}
