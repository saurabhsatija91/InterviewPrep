package lc_1;

import java.util.*;
import java.util.Map;

public class LongestSubstring {
	private String inputString;
	private int count = 0;
	
	private Map<Integer, String> map = new HashMap<>();
	
	public LongestSubstring (String inputString) {
		this.inputString = inputString;
	}
	
	public int longestSubstring () {
		for (int i = 0; i < inputString.length(); i++) {
			int localCount = 1;
			StringBuilder outputString = new StringBuilder();
			outputString.append(inputString.charAt(i));
			for (int j = i + 1;  j < inputString.length(); j++) {
				if (outputString.indexOf(Character.toString(inputString.charAt(j))) < 0) {
					outputString.append(inputString.charAt(j));
					localCount++;
				}
				this.count = (count > localCount) ? count : localCount;
			}
		}
		return this.count;
	}

	public int lengthOfLongestSubstring (String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int count = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				count = Math.max(count, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		
		return count;
	}
	
	public int lengthOfLongestSubstring2 (String s) {
		int n = s.length();
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			count = Math.max(count, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		
		return count;
	}
	
	public int lengthOfLongestSubstring3 (String s) {
		int count = 0, n = s.length();
		int[] index = new int[256];
		
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			count = Math.max(count, j - 1 + 1);
			index[s.charAt(j)] = j + 1;
		}	
		return count;
	}
	
	public static void main(String[] args) {
		LongestSubstring myApp = new LongestSubstring("abcabcdbcdefbcd");
		System.out.println(myApp.longestSubstring());
		System.out.println(myApp.lengthOfLongestSubstring("abcabcdbcdefbcd"));
		System.out.println(myApp.lengthOfLongestSubstring2("abcabcdbcdefbcd"));
		System.out.println(myApp.lengthOfLongestSubstring3("abcabcdbcdefbcd"));
	}
}
