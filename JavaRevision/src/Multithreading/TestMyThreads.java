package Multithreading;

class MyThreadC1 extends Thread {
	int myID;
	public MyThreadC1 (int id) {
		myID = id;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			int second = (int)(Math.random() * 500);
			try {
				Thread.sleep(second);
			} catch (InterruptedException e) {}
			System.out.println("myThreadC1-id" + myID + ": " + i);
		}
	}
}

class MyThreadC2 implements Runnable {
	int myID;
	public MyThreadC2(int id) {
		myID = id;
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				int second = (int)(Math.random() * 500);
				Thread.sleep(second);
			} catch (InterruptedException e) {}
			System.out.println("myThread-C2-id " + myID + ": " + i*i);
		}
	}
}

public class TestMyThreads {
	public static void main(String[] args) {
		Thread t1 = new MyThreadC1(1);
		Thread t2 = new Thread(new MyThreadC2(2));
		Thread t3 = new Thread(new MyThreadC2(3));
		Thread t4 = new Thread(new MyThreadC2(4));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
