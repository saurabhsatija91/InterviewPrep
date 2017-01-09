package First;

public class Enum {
	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
		THURSDAY, FRIDAY, SATURDAY
	}
	
	public static void main(String[] args) {
		for (Day d : Day.values()) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
}
