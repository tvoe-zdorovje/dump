package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
	public static void main(String[] args) {
		byte[][] a1 = new byte[][]{
				{1,1,0,0,1,1,0,0,0,1,1,0,0},
				{1,1,0,0,1,1,0,0,0,1,1,0,0},
				{0,0,0,0,1,1,0,0,0,0,0,0,0},
				{1,1,1,0,1,1,0,0,0,0,0,1,0},
				{1,1,1,0,1,1,0,0,0,0,0,0,0},
				{0,0,0,0,1,1,0,0,0,0,0,1,1},
				{0,0,0,0,1,1,0,0,0,0,0,1,1},
		};
		byte[][] a2 = new byte[][]{
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1}
		};

		int count1 = getRectangleCount(a1);
		System.out.println("count = " + count1 + ". Должно быть 2");
		int count2 = getRectangleCount(a2);
		System.out.println("count = " + count2 + ". Должно быть 4");
	}

	public static int getRectangleCount(byte[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {


				//находим верхний левый угол и стираем
				if (a[i][j] == 1) {
					clearRect(a, i, j);
					return 1 + getRectangleCount(a);
				}

			}
		}


		return 0;
	}

	public static void clearRect(byte[][] a, int row, int left) {
		for (int i = row; i < a.length; i++) {
			//конец фигуры
			if (a[i][left] == 0) return;

			for (int j = left; j < a[i].length; j++) {

				if (a[i][j] == 1) a[i][j] = 0;
				else break;

			}
		}

	}
}
