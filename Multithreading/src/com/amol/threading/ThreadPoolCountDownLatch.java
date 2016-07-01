package com.amol.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorCountDown implements Runnable {

	private CountDownLatch latch;

	public ProcessorCountDown(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("starting");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		latch.countDown();

		System.out.println("finished");
	}

}

public class ThreadPoolCountDownLatch {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(5);
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i = 0; i < 5; i++) {
			executorService.submit(new ProcessorCountDown(countDownLatch));
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed!!!");
	}
}
