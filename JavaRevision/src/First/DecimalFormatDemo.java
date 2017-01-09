package First;
import java.text.*;

public class DecimalFormatDemo {
	public static void customFormat (String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		System.out.println(value + " " + pattern + " " + output);
	}
	
	public static void main(String[] args) {
		customFormat("###,###,##.###", 123465.789);
	}
}
