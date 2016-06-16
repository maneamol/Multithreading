package com.amol.threading;

public class StartingThreadRunnable implements Runnable {

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
		Thread t1 = new Thread(new StartingThreadRunnable());
		t1.start();
		
		Thread t2 = new Thread(new StartingThreadRunnable());
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Anonumous class Hello " + i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t3.start();
	}
}
