package Multithreading;

import java.util.concurrent.*;

public class Consumer implements Runnable {
	private final BlockingQueue<Integer> sharedQueue;
	
	public Consumer (BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("Consumed: " + sharedQueue.take());
				
			} catch (InterruptedException e) {
				System.err.println(e.equals(e.toString()));
			}
		}
	}
 }
