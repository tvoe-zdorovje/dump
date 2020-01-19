package com.javarush.task.task18.task1813;



import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
	public static String fileName = "C:/tmp/result.txt";
	private FileOutputStream original;


	public AmigoOutputStream(FileOutputStream fileOutputStream) throws IOException {
		super(fileOutputStream.getFD());
		original = fileOutputStream;

	}


	@Override
	public void write(int b) throws IOException {
		original.write(b);
	}

	@Override
	public void write( byte[] b) throws IOException {
		original.write(b);
	}

	@Override
	public void write( byte[] b, int off, int len) throws IOException {
		original.write(b, off, len);
	}

	@Override
	public void flush() throws IOException {
		original.flush();
	}

	@Override
	public void close() throws IOException {
		flush();

		write("JavaRush © All rights reserved.".getBytes());
		original.close();
	}


	@Override
	public FileChannel getChannel() {
		return original.getChannel();
	}

	public static void main(String[] args) throws IOException {
		new AmigoOutputStream(new FileOutputStream(fileName));
	}

}
