package MultiThreadingRev;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	public void run() {
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
		
		Random random = new Random();
		
		try {
			for (int i = 0; i < importantInfo.length; i++) {
				queue.put(importantInfo[i]);
				Thread.sleep(1000);
			}
			queue.put("DONE");
		} catch (InterruptedException e) {}
	}
}
