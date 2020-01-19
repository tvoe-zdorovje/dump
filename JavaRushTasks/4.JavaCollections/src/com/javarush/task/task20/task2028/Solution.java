package com.javarush.task.task20.task2028;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		foo();
		Runtime runtime = Runtime.getRuntime();
		Thread t = new Thread(() -> {
			while (true) {
				double mem = (runtime.totalMemory() - runtime.freeMemory()) / 1024d / 1024d;
				if (mem >= 50) System.err.printf("\t\t\t\t\t%4.2f MB\n", mem);
				else System.out.printf("\t\t\t\t\t%.2f MB\n", mem);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}

		});

		t.start();

		long startTime = System.currentTimeMillis();

		List<String> three = new LinkedList<>();

		for (int i = 1; i < 100000; i++) {
			three.add(String.valueOf(i));
		}

		System.err.printf("1/2 Execution time: %f", (System.currentTimeMillis()-startTime)/1000f);

		for (int i = 99998; i > 0 ; i--) {
			three.remove(String.valueOf(i));
		}



		t.interrupt();
		System.err.printf("Execution time: %f", (System.currentTimeMillis()-startTime)/1000f);

	}

	private static void foo() {
		List<String> list = new CustomTree();

		for (int i = 1; i < 16; i++) {
			list.add(String.valueOf(i));
		}

		System.out.println(15 == list.size());
		System.out.println("3".equals(((CustomTree) list).getParent("8")));
		System.out.println(null == (((CustomTree) list).getParent("20")));

		list.remove("3");
		System.out.println(11 == list.size());
		System.out.println(null == (((CustomTree) list).getParent("8")));

		System.out.println(list.add("16"));;
		System.out.println("9".equals(((CustomTree) list).getParent("16")));

		list.remove("4");
		list.remove("5");
		list.remove("6");
		System.out.println(list.add("20"));
		System.out.println("1".equals(((CustomTree) list).getParent("20")));
	}
}
