package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


	    FileInputStream fileInput = new FileInputStream(args[1]);
	    FileOutputStream fileOutput = new FileOutputStream(args[2]);

		switch (args[0]){
			case "-e":
				encryption(fileInput, fileOutput);
				break;
			case "-d":
				decryption(fileInput, fileOutput);
				break;
		}

		fileInput.close();
		fileOutput.close();


    }

    public static void encryption(InputStream inFile, OutputStream outFile) throws IOException {

    	while (inFile.available()>0){
			outFile.write(inFile.read()<<1);
	    }
		outFile.flush();
    }
    public static void decryption(InputStream inFile, OutputStream outFile) throws IOException {
		while (inFile.available()>0){
			outFile.write(inFile.read()>>1);
		}
		outFile.flush();
    }



}
