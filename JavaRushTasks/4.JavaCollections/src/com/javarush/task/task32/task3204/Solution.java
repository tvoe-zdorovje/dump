package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {

	public static void main(String[] args) {
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}

	public static ByteArrayOutputStream getPassword() {

		Random random = new Random();
		ByteArrayOutputStream password = new ByteArrayOutputStream(8);
		boolean dig = false, upCase = false, lowCase = false;

		while (!dig || !upCase || !lowCase) {
			dig = false;
			upCase = false;
			lowCase = false;
			password.reset();

			for (int i = 0; i < 8; i++) {
				switch (random.nextInt(3)) {
					case 0:
						dig = true;
						password.write(48+random.nextInt(10));
						break;
					case 1:
						upCase = true;
						password.write(65+random.nextInt(26));
						break;
					case 2:
						password.write(97+random.nextInt(26));
						lowCase = true;
						break;
				}
			}

		}


		return password;
	}
}