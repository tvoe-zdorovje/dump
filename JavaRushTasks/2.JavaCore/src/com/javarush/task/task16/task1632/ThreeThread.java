package com.javarush.task.task16.task1632;

public class ThreeThread extends Thread {
	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				System.out.println("Ура");

				sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
