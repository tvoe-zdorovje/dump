package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
		RandomAccessFile file = new RandomAccessFile(args[0], "rw");
		byte[] bytes = new byte[args[2].length()];
		file.seek(Integer.parseInt(args[1]));
		file.read(bytes, 0, bytes.length);
		file.seek(file.length());

		file.write(String.valueOf(new String(bytes).equals(args[2])).getBytes());
		file.close();
    }
}
