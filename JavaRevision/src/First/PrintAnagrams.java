package First;

import java.util.Arrays;
import java.util.*;

public class PrintAnagrams {
	public static void printAllAnagrams (String string) {
		String alpha = alphabetize(string);
		
	}
	
	private static String alphabetize (String string) {
		char[] strArray = string.toCharArray();
		Arrays.sort(strArray);
		return new String(strArray);
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(args);
		Collections.shuffle(list);
		
		list.stream()
			.forEach(e -> System.out.format("%s ", e));
		System.out.println();
		for (String s : list)
			System.out.printf("%s ", s);
	}
}
