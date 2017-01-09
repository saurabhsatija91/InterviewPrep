package my.ds;

import java.util.*;

public class StackApplications {
	public static String decimalToBinary (int number) {
		StringBuilder binary = new StringBuilder();
		Stack<Integer> st = new Stack<Integer>();
		
		if (number == 0)
			binary.append("0");
		else while (number != 0) {
			st.push(number %  2);
			number /= 2;
		}
		
		while (!st.empty()) {
			try {
				binary.append(st.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return binary.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(decimalToBinary(10));
	}
}
