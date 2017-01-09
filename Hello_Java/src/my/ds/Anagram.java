package my.ds;

import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import java.io.*;

public class Anagram {
	static int minGroupSize = 8;
	
	private static String alphabetize(String str) {
		char[] arrStr = str.toCharArray();
		Arrays.sort(arrStr);
		return new String(arrStr);
	}
	
	public static void main(String[] args) {
		Map<String, List<String>> m = new HashMap<String, List<String>>();
		
		try {
			Scanner s = new Scanner(new File(args[0]));
			if (!s.hasNext()) 
				System.out.println("LOL");
			while (s.hasNext()) {
				String word = s.next();
				String alpha  = alphabetize(word);
				
				List<String> l = m.get(alpha);
				if (l == null) {
					m.put(alpha, l = new ArrayList<String>());
				}
				l.add(word);
			}
			s.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		for (List<String> l : m.values()) {
			if (l.size() >= minGroupSize)
				System.out.println(l.size() + ": " + l);
		}
//		System.out.println(m.keySet());
	}
}
