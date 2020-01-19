package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileReader fileReader = new FileReader(reader.readLine());
	    FileWriter fileWriter = new FileWriter(reader.readLine());
	    reader.close();

	    int i=1;
	    while (fileReader.ready()){
	    	if (i%2==0) fileWriter.write(fileReader.read());
	    	else fileReader.read();
	    	i++;
	    }
	    fileReader.close();
	    fileWriter.close();

    }
}
