package ConcurrentSystems;

public class Deadlock {
	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		
		public synchronized void bow (Friend bower) {
			System.out.format("%s: %s has bowed to me.", this.name, bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack (Friend bower) {
			System.out.format("%s: %s has bowed back to me.", this.name, bower.getName());
		}
	}
	
	public static void main(String[] args) {
		Friend ramesh = new Friend("Ramesh");
		Friend suresh = new Friend("Suresh");
		
		new Thread(new Runnable() {
			public void run() {
				ramesh.bow(suresh);
			}
		}
		).start();
		
		new Thread(new Runnable() {
			public void run() {
				suresh.bow(ramesh);
			}
		}
		).start();
	}
}
