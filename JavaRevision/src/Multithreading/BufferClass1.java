package Multithreading;

public class BufferClass1 {
	private int bufferCell = -1;
	private boolean writeable = true;
	
	public void setBuffer (int val) {
		while (!writeable) {
			try {
				wait();
			} catch(InterruptedException e) {}
		}
		
		bufferCell = val;
		writeable = false;
		notify();
	}
	public int getBuffer() {
		while(writeable) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		writeable = true;
		notify();
		return bufferCell;
	}
}
