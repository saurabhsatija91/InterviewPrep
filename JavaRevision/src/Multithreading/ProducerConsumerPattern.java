package Multithreading;

import java.util.concurrent.*;

public class ProducerConsumerPattern {
	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(3);
		
		Thread producerThread = new Thread (new Producer(sharedQueue));
		Thread consumerThread = new Thread (new Consumer(sharedQueue));
		
		producerThread.start();
		consumerThread.start();
	}
}
