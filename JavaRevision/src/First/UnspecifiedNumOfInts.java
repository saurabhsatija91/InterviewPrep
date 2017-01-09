package First;

public class UnspecifiedNumOfInts {
	public static void main(String[] args) {
		int numArgs = args.length;
		if (numArgs < 2) {
			System.out.println("Not enough args");
		} else {
			int sum = 0;
			for (int i = 0; i < numArgs; i++)
				sum += Integer.valueOf(args[i]).intValue();
		}
		System.out.println(sum);
	}
}
