package LeetCode;
import java.util.*;

public class wordPattern {
	public boolean isWordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map<Object, Integer> index = new HashMap<>();
		for (Integer i = 0; i < str.length(); i++) {
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i)) {
				return false;
			}
		}
		return true;
	}
}
