package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FiveThread extends Thread {

	@Override
	public void run() {

		long sum =0;
		String s;
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			while (!(s = reader.readLine()).equals("N") && !isInterrupted()) {
				sum+=Long.parseLong(s);
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
