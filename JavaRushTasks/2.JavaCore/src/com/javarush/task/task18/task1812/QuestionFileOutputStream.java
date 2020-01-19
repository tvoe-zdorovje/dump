package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

	AmigoOutputStream original;

	public QuestionFileOutputStream(AmigoOutputStream original) {
		this.original = original;
	}

	@Override
	public void flush() throws IOException {
		original.flush();
	}

	@Override
	public void write(int b) throws IOException {
		original.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		original.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		original.write(b, off, len);
	}

	@Override
	public void close() throws IOException {

		System.out.println("Вы действительно хотите закрыть поток? Д/Н");
InputStreamReader reader = new InputStreamReader(System.in);
		if (reader.read() == 'Д') original.close();
	}
}

