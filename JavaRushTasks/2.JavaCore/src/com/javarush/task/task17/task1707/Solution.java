package com.javarush.task.task17.task1707;

/* 
МВФ
*/

public class Solution {
	public static void main(String[] args) throws InterruptedException {
//		IMF fund = IMF.getFund();
//		IMF anotherFund = IMF.getFund();
//		System.out.println(fund == anotherFund);

		Solution s = new Solution();
		s.go();

	}

	public void go() throws InterruptedException {
Thread th;
Thread th2;
		test t = new test();
		th = new Thread(t);
		System.out.println("t1 start");
		th.start();
		th2 = new Thread(t);
		Thread.sleep(1000);
		System.out.println("t2 start");
		th2.start();
		System.out.println("main sleep");
		Thread.sleep(15000);
		System.out.println("main sleep end");
	}


	public class test implements Runnable{
		public volatile boolean first = false;
		public void foo(){
			synchronized (test.class) {
				System.out.println("foo start");
				int i = 0;
				while (i < 1000) {
					System.out.println("foo " + Thread.currentThread().getName());
					try {
						Thread.currentThread().sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			}
		}
		public void sleeping()  {
			synchronized (test.class) {
				try {
ThreadLocal<String> threadLocal = new ThreadLocal<>();
					Thread.sleep(3000);
					System.out.println("Sleep end " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			if (!first) {
				first = true;
				sleeping();

			}
			else{

				foo();
			}
		}
	}

}
