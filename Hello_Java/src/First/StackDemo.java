package First;

import java.util.*;

public class StackDemo {
	static void showPush (Stack st, int a) {
		st.push(new Integer(a));
		System.out.println("push (" + a + ")");
		System.out.println("stack: " + st);
	}
	
	static void showPop (Stack st) {
		System.out.print("pop-> ");
		Integer a = (Integer) st.pop();
		System.out.println(a);
		System.out.println("stack: " + st);
	}
	
	static void showPeek(Stack st) {
		System.out.println(st.peek());
	}
	
	public static void main(String[] args) {
		Stack st = new Stack();
		showPush(st, 10);
		showPush(st, 20);
		showPush(st, 30);
		showPush(st, 40);
		showPush(st, 50);
		
		showPop(st);
		showPeek(st);
		showPop(st);
		showPop(st);
		showPop(st);
		showPop(st);
		
		try {
			showPop(st);
		}
		catch (Exception e) {
			System.out.println("Empty Stack");
		}
	}
}
