package ConcurrentSystems;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ConsumerWithSynchronousQueue implements Runnable {
	private BlockingQueue<String> drop;
	
	public ConsumerWithSynchronousQueue(BlockingQueue<String> drop) {
		this.drop = drop;
	}
	
	public void run() {
		Random random = new Random();
		try {
			for (String message = drop.take();
					message != "DONE!!"; message = drop.take()) {
				System.out.format("[Message Recieved]: %s%n", message);
				Thread.sleep(random.nextInt(4000));
			}
		} catch (InterruptedException e) {}
	}
}
