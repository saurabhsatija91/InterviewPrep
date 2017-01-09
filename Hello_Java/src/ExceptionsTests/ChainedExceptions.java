package ExceptionsTests;

public class ChainedExceptions {
	public static void methodOne() {
		methodTwo();
	}
	public static void methodTwo() {
		method3();
	}
	public static void method3() {
		method4();
	}
	public static void method4() {
		throw new NullPointerException();
	}
	
	public static void main(String[] args) {
		try {
			methodOne();
		} catch (NullPointerException e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int i = 0 ; i < element.length; i++) {
				System.err.println(element[i].getFileName() + " " + element[i].getMethodName() + " " +
						element[i].getLineNumber());
			}
		}
	}
}
