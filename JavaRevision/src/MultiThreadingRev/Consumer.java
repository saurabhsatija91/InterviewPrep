package MultiThreadingRev;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	
	public Consumer (BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	public void run() {
		Random random = new Random();
		try {
			for (String message = queue.take();
					!message.equals("DONE");) {
				System.out.println("Message Received: " + message);
				
				Thread.sleep(random.nextInt(5000));
			} 
		} catch (InterruptedException e) {}
	}
}
