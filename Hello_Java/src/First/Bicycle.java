package First;

public class Bicycle {
	public int cadence;
	public int gear;
	public int speed;
	
	public Bicycle(int startCadence, int startGear, int startSpeed) {
		cadence = startCadence;
		gear = startGear;
		speed = startSpeed;
	}
	
	public void setCadence(int newVal) {
		cadence = newVal;
	}
	
	public void setGear(int newVal) {
		gear = newVal;
	}
	
	public void applyBreaks(int decrement) {
		speed -= decrement;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	public static int byStatic() {
		return 15;
	}
	
	public String basic(int num) {
		return "This is super class" + num;
	}
	
	public void printMethod(){
		System.out.println("This is from Bicycle");
	}
}
