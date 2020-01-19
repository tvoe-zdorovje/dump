package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter{
	private FileWriter fileWriter;



	public FileConsoleWriter(String fileName) throws IOException {
		fileWriter = new FileWriter(fileName);
	}

	public FileConsoleWriter(String fileName, boolean append) throws IOException {
		fileWriter = new FileWriter(fileName, append);	}

	public FileConsoleWriter(File file) throws IOException {
		fileWriter = new FileWriter(file);
	}

	public FileConsoleWriter(File file, boolean append) throws IOException {
		fileWriter = new FileWriter(file, append);
	}

	public FileConsoleWriter(FileDescriptor fd) {
		fileWriter = new FileWriter(fd);
	}

//	public FileConsoleWriter(String fileName, Charset charset) throws IOException {
//		fileWriter = new FileWriter(fileName, charset);
//	}

//	public FileConsoleWriter(String fileName, Charset charset, boolean append) throws IOException {
//		fileWriter = new FileWriter(fileName, charset, append);
//	}
//
//	public FileConsoleWriter(File file, Charset charset) throws IOException {
//		fileWriter = new FileWriter(file, charset);
//	}
//
//	public FileConsoleWriter(File file, Charset charset, boolean append) throws IOException {
//		fileWriter = new FileWriter(file, charset, append);
//	}



	public void write(int c) throws IOException {
		System.out.println(c);
		fileWriter.write(c);
	}


	public void write(char[] cbuf, int off, int len) throws IOException {
		for (int i = off; i < off+len; i++) {
			System.out.print(cbuf[i]);
		}
		fileWriter.write(cbuf, off, len);
	}


	public void write(String str, int off, int len) throws IOException {
		System.out.println(str.substring(off, off+len));
		fileWriter.write(str, off, len);
	}


	public void close() throws IOException {
		fileWriter.close();
	}


	public void write(char[] cbuf) throws IOException {

		fileWriter.write(cbuf);
		for (char c : cbuf) {
			System.out.print(c);
		}
	}


	public void write(String str) throws IOException {

		fileWriter.write(str);
		System.out.println(str);
	}

	public static void main(String[] args) throws IOException {
		char[] cs = "pidor".toCharArray();
		FileConsoleWriter writer = new FileConsoleWriter("C:\\Users\\dr0sh\\OneDrive\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1916\\file");
		writer.write(cs, 0, cs.length);
		writer.close();
    }



}
