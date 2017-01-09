package First;

import java.time.LocalDate;

public class Calculator {
	interface IntegerMath {
		int operation(int a, int b);
	}
	
	public int operationBinary(int a, int b, IntegerMath op) {
		return op.operation(a,  b);
	}
	
	public static void main(String[] args) {
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		
		Calculator myCalc = new Calculator();
		
		System.out.println("Addition of 5 and 3: " + myCalc.operationBinary(5, 3, addition));
		System.out.println("Result of 5 - 3: " + myCalc.operationBinary(5, 3, subtraction));
		
		System.out.println(LocalDate.now());
	}

}
