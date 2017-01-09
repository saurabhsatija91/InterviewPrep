package First;

import java.text.DecimalFormat;

public class AddArgs {
	public static void main(String[] args) {
/*		int sum = 0;
		if (args.length <= 1) {
			System.err.println("Enter at least 2 args.");
			System.exit(-1);
		}
		for (int i = 0; i < args.length; i++) {
			sum += Integer.valueOf(args[i]);
		}
		System.out.println("The total sum is: " + sum);
*/
		Double sum = 0.0;
		if (args.length <= 1) {
			System.err.println("Enter at least 2 args.");
			System.exit(-1);
		}
		for (int i = 0; i < args.length; i++) {
			sum += Double.valueOf(args[i]);
		}
		
		DecimalFormat myFormat = new DecimalFormat("###,###.##");
		String output = myFormat.format(sum);
		
		System.out.println(output);
	}
}
