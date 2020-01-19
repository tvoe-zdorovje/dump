package com.javarush.task.task16.task1632;

public class FourThread extends Thread implements Message {
	@Override
	public void showWarning() {
		if (isAlive()) interrupt();
	}

	@Override
	public void run() {
		while (!isInterrupted()){}
	}
}
