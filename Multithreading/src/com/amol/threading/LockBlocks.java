package com.amol.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LockBlocks {
	Random random = new Random();

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	public void stageOne() throws InterruptedException {
		synchronized(list1) {
			Thread.sleep(1);
			list1.add(random.nextInt(100));
		}
	}

	public synchronized void stageTwo() throws InterruptedException {
		synchronized (list2) {
			Thread.sleep(1);
			list2.add(random.nextInt(100));
		}
	}

	public void process() throws InterruptedException{
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void threadProcess() throws InterruptedException{
		System.out.println("starting....");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		});

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(list1.size() + " " + list2.size());
		System.out.println("Ending");

		System.out.println("time " + (System.currentTimeMillis() - start));
	}

	public static void main(String[] args) throws InterruptedException{
		new LockBlocks().threadProcess();
	}
}
