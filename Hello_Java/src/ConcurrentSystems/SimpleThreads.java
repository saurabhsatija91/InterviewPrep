package ConcurrentSystems;

public class SimpleThreads {
	
	static void threadMessage (String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s", threadName, message);
		System.out.println();
	}

	private static class MessageLoop implements Runnable {
		public void run () {
			String importantInfo[] = {
	                "Mares eat oats",
	                "Does eat oats",
	                "Little lambs eat ivy",
	                "A kid will eat ivy too"
	            };
			try {
				for (int i = 0; i < importantInfo.length; i++) {
					Thread.sleep(4000);
					threadMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				threadMessage("I wasn't done.");
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		long patience = 1000 * 15;	// 15 sec delay
		
		if (args.length > 0)
			try {
				patience = Integer.parseInt(args[0]) * 1000;
			} catch (NumberFormatException e) {
				System.out.println("Number should be an integer");
				System.exit(-1);
			}
		
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		while (t.isAlive()) {
			threadMessage("Still waiting...");
			t.join(1000);
			
			if ((System.currentTimeMillis() - startTime) > patience
					&& t.isAlive()) {
				threadMessage("Tired of waiting");
				t.interrupt();
				
				t.join();
			}
		}
		threadMessage("Finally.");
	}
}
