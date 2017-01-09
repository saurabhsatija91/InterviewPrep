package ConcurrentSystems;

import java.util.concurrent.*;
import java.util.concurrent.TimeUnit.*;

public class BeeperControl {
	private final ScheduledExecutorService scheduler = 
			Executors.newScheduledThreadPool(1);
	
	public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
				System.out.println("Beep");
			}
		};
		
		final ScheduledFuture<?> beeperHandle = 
				scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
		
		scheduler.schedule (new Runnable() {
			public void run() { beeperHandle.cancel(true); }
		}, 60 * 60, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		BeeperControl myApp = new BeeperControl();
		myApp.beepForAnHour();
	}
}
