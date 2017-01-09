package First;
import java.util.Arrays;

public class Hello {
	public void method1 (int a, String str) {
		System.out.println("Method1: " + a + " " + str);
	}
	
	public void method2 (String str, int a) {
		System.out.println("Method2: " + a + " " + str);
	}
	
	public static void main(String []args){
		System.out.println("Hello from Java");
		
		char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
	            'i', 'n', 'a', 't', 'e', 'd'};
		int i = 10;
		
//		char[] copyTo = new char[7];
//		System.arraycopy(copyFrom, 2, copyTo, 0, 7);
//		char[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 1, 9);
		char[] copyTo = Arrays.copyOf(copyFrom, 9);
		
		System.out.println("copyTo: " + new String(copyTo));
		System.out.println(i);
		
		Hello obj = new Hello();
		
		obj.method1(10, "Saurabh");
		obj.method2("Satija", 10);
		
	}	
}
