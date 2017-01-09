package Geeks4geeks;
import java.util.*;

public class MinWindowSubstring {
	public static String minWindow (String s, String t) {
		if (t.length() > s.length())
			return "";
		
		String minWindow = "";
		
		HashMap<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			dict.put(c, (dict.containsKey(c) ? (dict.get(c) + 1) : 1));
		}
		
		HashMap<Character, Integer> found = new HashMap<>();
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int foundCount = 0;
		
		while (end < s.length()) {
			char c = s.charAt(end);
			if (dict.containsKey(c)) {
				if (found.containsKey(c)) {
					if (found.get(c) < dict.get(c))
						foundCount++;
					found.put(c, found.get(c) + 1);
				} else {
					found.put(c, 1);
					foundCount++;
				}
			}
			if (foundCount == t.length()) { //All chars found.
				char sc = s.charAt(start);
				while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
					if (found.containsKey(sc) && found.get(sc) > dict.get(sc))
						found.put(sc,  found.get(sc) - 1);
					start++;
					sc = s.charAt(start);
				}
				if (end - start + 1 < minLen) {
					minWindow = s.substring(start, end + 1);
					minLen = end - start +1;
				}
			}
			end++;
		}
		return minWindow;
		
	}
}
