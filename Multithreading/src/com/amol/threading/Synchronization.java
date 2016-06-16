package com.amol.threading;

public class Synchronization {
	private int count = 0;
	public static void main(String[] args) {
		Synchronization synchronization = new Synchronization();
		synchronization.increament();
	}
	private synchronized void inc() {
		count++;
	}
	public void increament() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i<10000; i++) {
					inc();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i<10000; i++) {
					inc();
				}
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(count);
	}
}
