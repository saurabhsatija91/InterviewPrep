package lc_1;

public class ReverseInteger {
	public static int reverseInt (int num) {
		boolean negative = (num < 0);
		num = Math.abs(num);
		int out = 0;
		while (num > 0) {
			out = out * 10 + num % 10;
			num = num / 10;
		}
		
		return negative ? -out : out;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseInt(-326));
	}
}
