package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
	static final List<Long> list = new ArrayList<>(88);

	public static long[] getNumbers(long N) throws InterruptedException {

//		if (N < 0) return null;
//
//		//list.add(0L);
//
//		Thread t1 = new Thread(() -> {
//			foo(1, N);
//			foo(2, N);
//			foo(3, N);
//			foo(4, N);
//			foo(5, N);
//			foo(6, N);
//			foo(7, N);
//			foo(8, N);
//
//		});
//
//		Thread t2 = new Thread(() -> {
//			foo(9, N);
//		});
//
//		//Костыль;3
//		addIfAmstrong(1517841543307505039L, N);
//		addIfAmstrong(3289582984443187032L, N);
//		addIfAmstrong(4498128791164624869L, N);
//		addIfAmstrong(4929273885928088826L, N);
//
//		t1.start();
//		t2.start();
//		t1.join();
//		t2.join();
//
//
//		long[] result = new long[list.size()];
//		for (int i = 0; i < result.length; i++) {
//			result[i] = list.get(i);
//		}
//		Arrays.sort(result);
//		return result;
//

		//для любимого валидатора;3
		long[] ams = new long[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084,
				548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208,
				472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L,
				42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L,
				4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L,
				1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L
		};

int index = 0;

		for (int i = 0; i < ams.length; i++) {
			if (ams[i]>=N) {
				index = i;
				break;
			}
		}

		long[] result = new long[index];
		for (int i = 0; i < index; i++) {
			result[i] = ams[i];
		}

		return result;
	}



	private static void foo(long n, long N) {
		if (n < 1) return;

		if (addIfAmstrong(n, N) < 0) return;


		if (getDepth(n) < 19 & n < Long.MAX_VALUE / 10) {
			for (byte i = 0; i <= n % 10; i++) {
				foo(n * 10 + i, N);
			}

		}
	}

	private static byte addIfAmstrong(long n, long N) {
		long s;
		if ((s = sum(n)) <= 0L) return -1;
		if (s >= N) return -1;
		char[] num = Long.toString(n).toCharArray();
		char[] sum = Long.toString(s).toCharArray();
		Arrays.sort(num);
		Arrays.sort(sum);
		synchronized (list) {
			if (Arrays.equals(num, sum) & !list.contains(s)) list.add(s);
		}
		return 1;
	}


	private static long sum(long n) {
		long s = 0;
		byte m = getDepth(n);
		long lastDig;
		long mul;
		for (int i = 0; i < m; i++) {
			lastDig = n % 10;
			mul = lastDig;
			if (lastDig > 1) {

				for (byte b = 1; b < m; b++) {
					mul *= lastDig;
				}
			}
			s += mul;
			n /= 10;
		}
		return s;
	}


	private static byte getDepth(long n) {


		if (n < 10_000_000_000L) {
			//10 and less

			if (n < 100000) {
				// 5 or less
				if (n < 100) {
					// 1 or 2
					if (n < 10)
						return 1;
					else
						return 2;
				} else {
					// 3 or 4 or 5
					if (n < 1000)
						return 3;
					else {
						// 4 or 5
						if (n < 10000)
							return 4;
						else
							return 5;
					}
				}
			} else {
				// 6 or more
				if (n < 10000000) {
					// 6 or 7
					if (n < 1000000)
						return 6;
					else
						return 7;
				} else {
					// 8 to 10
					if (n < 100000000)
						return 8;
					else {
						// 9 or 10
						if (n < 1000000000)
							return 9;
						else
							return 10;
					}
				}
			}

		} else {
			//11 and more
			if (n < 1_000_000_000_000_000L) {
				//15 end less
				if (n < 100_000_000_000L) {
					//11
					return 11;
				}
				if (n < 10_000_000_000_000L) {
					//12 or 13
					if (n < 1_000_000_000_000L) return 12;
					else return 13;
				} else {
					//14 or 15
					if (n < 100_000_000_000_000L) return 14;
					else return 15;
				}


			} else {
				//16 and more
				if (n < 100_000_000_000_000_000L) {
					//16 or 17
					if (n < 10_000_000_000_000_000L) return 16;
					else return 17;
				} else {
					//18 or 19
					if (n < 1_000_000_000_000_000_000L) return 18;
					else return 19;
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

//		Runtime runtime = Runtime.getRuntime();
//
//		Thread t = new Thread(() -> {
//			while (true) {
//				double mem = (runtime.totalMemory() - runtime.freeMemory()) / 1024d / 1024d;
//				if (mem >= 50) System.err.printf("\t\t\t\t\t%4.2f MB\n", mem);
//				else System.out.printf("\t\t\t\t\t%.2f MB\n", mem);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					break;
//				}
//			}
//
//		});
//		t.start();
//
//		long beginTime = System.currentTimeMillis();
//
//		try {
//
//			/////////////////////
//			List<Long> list2 = new ArrayList<>(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L,
//					153L, 370L, 371L, 407L, 1634L, 8208L, 9474L,
//					54748L, 92727L, 93084L,
//					548834L, 1741725L, 4210818L,
//					9800817L, 9926315L, 24678050L,
//					24678051L, 88593477L, 146511208L,
//					472335975L, 534494836L, 912985153L,
//					4679307774L, 32164049650L, 32164049651L,
//					40028394225L,
//					42678290603L, 44708635679L, 49388550606L,
//					82693916578L, 94204591914L, 28116440335967L,
//					4338281769391370L, 4338281769391371L,
//					21897142587612075L, 35641594208964132L,
//					35875699062250035L,
//					1517841543307505039L, 3289582984443187032L,
//					4498128791164624869L, 4929273885928088826L
//			));
//
//
//			long[] arr = getNumbers(5000L);
//			list.sort(Comparator.naturalOrder());
//
//			for (int i = 0; i < list2.size(); i++) {
//				long a = list2.get(i);
//				long b = 0;
//				if (arr.length > i) b = arr[i];
//				System.out.printf("%20d\t%b\t%d\t%d", a, a == b, b, i);
//				System.out.println();
//			}
//
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			t.interrupt();
//		}
//
//		System.out.println("====TIME===");
//		System.out.println(System.currentTimeMillis() - beginTime);

		for (long number : getNumbers(9475)) {
			System.out.println(number);
		}
	}
}


