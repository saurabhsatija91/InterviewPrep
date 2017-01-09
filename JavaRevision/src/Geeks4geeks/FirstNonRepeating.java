package Geeks4geeks;

import java.util.*;
import java.util.Map.Entry;

public class FirstNonRepeating {
	//LinkedHashMap, 2 loops required
	
	public static char getFirstNonRepeatingChar (String string) {
		Map<Character, Integer> counts = new LinkedHashMap<>(string.length());
		
		for (char c : string.toCharArray()) {
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1);
		}
		for (Entry<Character, Integer> entry : counts.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		throw new RuntimeException("Did not find any non repeating character.");
	}
	
	//Only one pass, time vs space trade off
	public static char firstNonRepeatingChar (String string) {
		Set<Character> repeating = new HashSet<>();
		List<Character> nonRepeating = new ArrayList<>();
		for (int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);
			if (repeating.contains(letter)) {
				continue;
			}
			if (nonRepeating.contains(letter)) {
				nonRepeating.remove((Character) letter);
				repeating.add(letter);
			} else {
				nonRepeating.add(letter);
			}
		}
		return nonRepeating.get(0);
	}
	
	//Two loops, store in map and then compare string letter counts while traversing
	//again
	
	public static char firstNonRepeatedChar (String string) {
		Map<Character, Integer> counts = new HashMap<>();
		for (char c : string.toCharArray()) {
			counts.put(c, (counts.containsKey(c) ? counts.get(c) + 1 : 1));
		}
		
		for (char c : string.toCharArray()) {
			if (counts.get(c) == 1)
				return c;
		}
		throw new RuntimeException("Did not find any non repeating char.");
	}
	
	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatingChar("Saurabh Satija"));
		System.out.println(firstNonRepeatingChar("Saurabh Satija"));
		System.out.println(firstNonRepeatingChar("AaB"));
	}
}
