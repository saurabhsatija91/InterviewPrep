package Geeks4geeks;

public class LongestCommonPrefix {
	public static String longestCommonPrefix (String[] strings) {
		if (strings == null || strings.length == 0)
			return "";
		if (strings.length == 1)
			return strings[0];
		
		int minLen = Integer.MAX_VALUE;
		
		for (String str : strings) {
			if (minLen > strings.length) {
				minLen = str.length();
			}
		}
		
		for (int i = 0; i < minLen; i++) {
			for (int j = 0; j < strings.length - 1; j++) {
				String s1 = strings[j];
				String s2 = strings[j+1];
				if (s1.charAt(i) != s2.charAt(i))
					return s1.substring(0, i);
			}
		}
		
		return strings[0].substring(0, minLen);
	}
}
