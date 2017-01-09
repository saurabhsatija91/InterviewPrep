package MultiThreadingRev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class CustomTask implements Runnable {
	private int seqPosition;
	private Semaphore sem;
	
	CustomTask (int seqPosition, Semaphore sem) {
		this.seqPosition = seqPosition;
		this.sem = sem;
		System.out.println("Created Task : " + seqPosition);
	}
	
	public void run() {
		try {
			for(;;) {
				boolean isAcquired = sem.tryAcquire(seqPosition, 1000,
						TimeUnit.MILLISECONDS);
				if (!isAcquired) {
					Thread.sleep(2000);
					continue;
				} else
					break;
			}
			
			System.out.println("Task " + seqPosition + " is completed");
			sem.release(seqPosition+1);
		} catch (InterruptedException e) {}
	}
}

public class SequentialTaskExecutor {
	ExecutorService service = Executors.newFixedThreadPool(10);
	Semaphore sem = new Semaphore(10);
	
	void runTasks() {
		try {
			sem.acquire(9);
			service.submit(new CustomTask(2, sem));
			service.submit(new CustomTask(4, sem));
			service.submit(new CustomTask(3, sem));
			service.submit(new CustomTask(1, sem));
			service.submit(new CustomTask(7, sem));
			service.submit(new CustomTask(6, sem));
			service.submit(new CustomTask(8, sem));
			service.submit(new CustomTask(9, sem));
			service.submit(new CustomTask(10, sem));
			service.submit(new CustomTask(5, sem));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SequentialTaskExecutor exc = new SequentialTaskExecutor();
		exc.runTasks();
	}
}
