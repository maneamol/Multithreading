package com.amol.threading;

class Runner extends Thread {
	@Override
	public void run() {
		

		for (int i = 1; i <= 10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class StartingThreadsExtends extends Thread {
	@Override
	public void run() {
		

		for (int i = 1; i <= 10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//Runner extends1 = new Runner();
		StartingThreadsExtends t1 = new StartingThreadsExtends();
		t1.start();
		
		StartingThreadsExtends t2 = new StartingThreadsExtends();
		t2.start();
	}

}
