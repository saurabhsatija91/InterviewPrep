package Multithreading;

/*public class HelloRunnable implements Runnable{
	public void run() {
		System.out.println("Hello from Thread");
	}
	
	public static void main(String[] args) {
		(new Thread(new HelloRunnable())).start();
	}
}
*/

public class HelloRunnable extends Thread {
	public void run() {
		System.out.println("Hello from another implementation of thread");
	}
	
	public static void main(String[] args) {
		(new HelloRunnable()).start();
	}
}