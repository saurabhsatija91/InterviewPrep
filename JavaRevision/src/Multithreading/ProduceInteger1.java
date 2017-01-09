package Multithreading;

public class ProduceInteger1 extends Thread{
	private BufferClass1 pBuffer;
	public ProduceInteger1 (BufferClass1 pBuffer) {
		this.pBuffer = pBuffer;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				System.err.println(e.toString());
			}
			pBuffer.setBuffer(i);
			System.out.println("Producer sets bufferCell to: " + i);
		}
	}
}
