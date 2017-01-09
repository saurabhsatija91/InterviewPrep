package MultiThreadingRev;

import java.util.concurrent.Semaphore;

interface CustomLock {
	public void lock();
	public boolean tryLock();
	public void unlock();
}

public class CustomRentrantLock implements CustomLock{
	private int lockHoldCount;
	private long threadId;
	
	public CustomRentrantLock() {
		this.lockHoldCount = 0;
	}
	
	public synchronized void lock() {
		if (this.lockHoldCount == 0) {
			this.lockHoldCount++;
			this.threadId = Thread.currentThread().getId();
		} else if (this.lockHoldCount > 0 && this.threadId ==
				Thread.currentThread().getId()) {
			this.lockHoldCount++;
		} else {
			try {
				wait();
				this.lockHoldCount++;
				this.threadId = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void unlock() {
		if (lockHoldCount == 0)
			throw new IllegalMonitorStateException();
		lockHoldCount--;
		
		if (lockHoldCount == 0) {
			notify();
		}
	}
	
	public synchronized boolean tryLock() {
		if (lockHoldCount == 0) {
			lock();
			return true;
		} else
			return false;
	}
}
