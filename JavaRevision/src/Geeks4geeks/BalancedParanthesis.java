package Geeks4geeks;
import java.util.*;

public class BalancedParanthesis {
	private static final Map<Character, Character> brackets = 
			new HashMap<>();
	static {
		brackets.put('(', ')');
		brackets.put('[', ']');
		brackets.put('{', '}');
	}
	
	public static boolean isBalanced (String string) {
		if (string.length() == 0) {
			throw new IllegalArgumentException ("Str len is 0");
		}
		
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			if (brackets.containsKey(string.charAt(i))) {
				stack.push(string.charAt(i));
			} else if (brackets.values().contains(string.charAt(i))) {
				if (stack.isEmpty() || (string.charAt(i) != brackets.get(stack.pop())))
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isBalanced("{["));
	}
}
