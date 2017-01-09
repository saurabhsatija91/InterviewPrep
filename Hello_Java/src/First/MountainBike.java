package First;

public class MountainBike extends Bicycle {
	public int seatHeight;
	
	public MountainBike(int startCadence, int startGear, int startSpeed, int startHeight) {
		super(startCadence, startGear, startSpeed);
		this.seatHeight = startHeight;
	}

	public static int byStatic() {
		return 20;
	}
	
	@Override
	public String basic(int num) {
		return "This is subclass" + num;
	}
	
	@Override
	public void printMethod() {
		super.printMethod();
		System.out.println("This is from MountainBike.");
	}
	
	public static void main(String[] args) {
		Bicycle myBike = new Bicycle(1, 2, 3);
		MountainBike myMountainBike = new MountainBike(4, 5, 6, 10);
		Bicycle newObj = myMountainBike;
		
		Integer num = null;
		num = num.decode("0x011");
		int n = num.parseInt("011", 8);
//		System.out.println(num.toString());
//		System.out.println(n);
		
		myMountainBike.printMethod();
		myBike.printMethod();
		
		System.out.println(myBike.getClass());
		System.out.println(newObj.getClass().getFields());
		System.out.println(myBike.hashCode());
		System.out.println(myBike.toString());
	
		
		Integer num2 = Integer.valueOf(65);
		System.out.println(Integer.toHexString(num2));
	}
}
