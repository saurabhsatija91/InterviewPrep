package MultiThreadingRev;

public class OddEvenMTPrint {
	private boolean evenFlag = false;
	
	private class EvenThread implements Runnable {
		public void run() {
			int even = 2;
			while (!evenFlag) {
	//			try{
					//wait();
	//			} catch (InterruptedException e) {}
			}
			System.out.println(Thread.currentThread().getName() + " >> " + even);
			even += 2;
			evenFlag = false;
		//	notifyAll();
		}
	}
	
	private class OddThread implements Runnable {
		public void run() {
			int odd = 1;
		
			while (evenFlag) {
	//			try{
				//	wait();
//				} catch (InterruptedException e) {}
			}
			System.out.println(Thread.currentThread().getName() + " >> " + odd);
			odd += 2;
			evenFlag = true;
	//		notifyAll();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		OddEvenMTPrint app = new OddEvenMTPrint();
		Thread oddThread = new Thread (app.new OddThread(), "ODD-Thread");
		Thread evenThread = new Thread (app.new EvenThread(), "EVEN-Thread");
		
		oddThread.start();
		evenThread.start();
	}
}
