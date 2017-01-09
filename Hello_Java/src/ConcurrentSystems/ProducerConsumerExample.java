package ConcurrentSystems;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		//Implementation with DROP
/*		Drop drop = new Drop();
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
*/	
		BlockingQueue<String> bQueue = new SynchronousQueue<>();
		
		(new Thread(new ProducerWithSynchronousQueue(bQueue))).start();
		(new Thread(new ConsumerWithSynchronousQueue(bQueue))).start();
	}
}
