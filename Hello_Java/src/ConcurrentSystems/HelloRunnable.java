package ConcurrentSystems;

public class HelloRunnable implements Runnable{
	public void run() {
		try {
			Thread.sleep(1000);
			while (true)
				System.out.println("Hello from this thread.");
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			return;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new HelloRunnable());
		t1.start();
		Thread.sleep(5000);
		t1.interrupt();
		
	}
}
