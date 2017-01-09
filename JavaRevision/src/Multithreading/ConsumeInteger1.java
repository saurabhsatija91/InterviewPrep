package Multithreading;

public class ConsumeInteger1 extends Thread{
	private BufferClass1 cBuffer;
	public ConsumeInteger1 (BufferClass1 cBuffer) {
		this.cBuffer = cBuffer;
	}
	
	public void run() {
		int val;
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				System.err.println(e.toString());
			}
			val = cBuffer.getBuffer();
			System.out.println("CosumeInteger read: " + val);
		}
	}
}
