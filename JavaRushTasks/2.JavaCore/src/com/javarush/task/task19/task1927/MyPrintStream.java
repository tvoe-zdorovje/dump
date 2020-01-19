package com.javarush.task.task19.task1927;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;

public class MyPrintStream extends PrintStream {
	private PrintStream original;
	private int rowCount = 0;

	public MyPrintStream(OutputStream out) {
		super(out);
		original = new PrintStream(out);
	}

	public MyPrintStream(PrintStream stream){
		super(stream);
		original = stream;
	}


	@Override
	public void flush() {
		original.flush();
	}

	@Override
	public void close() {
		original.close();
	}

	@Override
	public boolean checkError() {
		return original.checkError();
	}


	@Override
	public void write(int b) {
		original.write(b);
	}

	@Override
	public void write(byte[] buf, int off, int len) {
		original.write(buf, off, len);
	}

	@Override
	public void print(boolean b) {
		original.print(b);
	}

	@Override
	public void print(char c) {
		original.print(c);
	}

	@Override
	public void print(int i) {
		original.print(i);
	}

	@Override
	public void print(long l) {
		original.print(l);
	}

	@Override
	public void print(float f) {
		original.print(f);
	}

	@Override
	public void print(double d) {
		original.print(d);
	}

	@Override
	public void print(char[] s) {
		original.print(s);
	}

	@Override
	public void print(String s) {
		original.print(s);
	}

	@Override
	public void print(Object obj) {
		original.print(obj);
	}

	@Override
	public void println() {
		original.println();
		ad();
	}

	@Override
	public void println(boolean x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(char x) {
		original.println(x);
	}

	@Override
	public void println(int x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(long x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(float x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(double x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(char[] x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(String x) {
		original.println(x);
		ad();
	}

	@Override
	public void println(Object x) {
		original.println(x);
		ad();
	}

	@Override
	public PrintStream printf(String format, Object... args) {
		return original.printf(format, args);
	}

	@Override
	public PrintStream printf(Locale l, String format, Object... args) {
		return original.printf(l, format, args);
	}

	@Override
	public PrintStream format(String format, Object... args) {
		return original.format(format, args);
	}

	@Override
	public PrintStream format(Locale l, String format, Object... args) {
		return original.format(l, format, args);
	}

	@Override
	public PrintStream append(CharSequence csq) {
		return original.append(csq);
	}

	@Override
	public PrintStream append(CharSequence csq, int start, int end) {
		return original.append(csq, start, end);
	}

	@Override
	public PrintStream append(char c) {
		return original.append(c);
	}

	@Override
	public void write(byte[] b) throws IOException {
		original.write(b);
	}



	private void ad(){
		rowCount++;
		if (rowCount==2) {
			original.println("JavaRush - курсы Java онлайн");
			rowCount = 0;
		}
	}
}
