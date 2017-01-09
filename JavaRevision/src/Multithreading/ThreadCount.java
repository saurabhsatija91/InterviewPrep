package Multithreading;

public class ThreadCount {
	public static void main(String[ ] args)
	{
		int originalThreadCount = Thread.activeCount();
		System.out.println("thread count=" + originalThreadCount);
		for (int j = 0; j < 1; j++) {
			Thread producer = new ProduceInteger1(null);
			Thread consumer = new ConsumeInteger1(null);
			producer.start();
			consumer.start();
			System.out.println("main thread count=" + Thread.activeCount());
		}
		while (Thread.activeCount() > originalThreadCount) // another way is to use join()
		{
			System.out.println("The remaining thread count = " + Thread.activeCount() );
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {}
		}
	}
}
