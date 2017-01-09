package First;

import java.util.*;

public class WordFrequency {
	public static void wordFreq(String[] strArray) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : strArray) {
			if (!map.containsKey(s)) {
				map.put(s, 1);
			} else {
				map.put(s, map.get(s) + 1);
			}
		}
		System.out.println("m.size(): " + map.size());
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		String[] strArray = {"Sa", "Sat", "Sa", "fre", "fre"};
		WordFrequency.wordFreq(strArray);
	}
}
