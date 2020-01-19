package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    FileReader fr = new FileReader(reader.readLine());
	    FileWriter fw = new FileWriter(reader.readLine());
	    reader.close();


	    reader = new BufferedReader(fr);
	    BufferedWriter writer = new BufferedWriter(fw);

	    while (reader.ready()){
		    writer.write(reader.readLine().replaceAll("\\.", "!"));
	    }
	    reader.close();
	    writer.close();

    }
}
