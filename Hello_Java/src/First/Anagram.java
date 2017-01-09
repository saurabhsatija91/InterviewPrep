package First;

import java.util.ArrayList;
import java.util.List;

public class Anagram {
	public boolean isAnagram(String str1, String str2) {
		String cleanStr1 = removeJunk(str1);
		String cleanStr2 = removeJunk(str2);
		
		cleanStr1 = sort(cleanStr1);
		cleanStr2 = sort(cleanStr2);

		return cleanStr1.equals(cleanStr2);
	}
	
	protected static String sort(String str) {
		char[] charArray = str.toCharArray();
		java.util.Arrays.sort(charArray);
		return new String(charArray);
	}
	
	protected static String removeJunk(String str) {
		StringBuilder stringBuf = new StringBuilder(str.length());
		
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i)))
				stringBuf.append(str.charAt(i));
		}
		return stringBuf.toString();
	}
	
	public static void main(String[] args) {
		Anagram myApp = new Anagram();
		System.out.println(myApp.isAnagram("parliament", "partial men"));
		
	}
	

	void foo(List<?> i) {
		foohelper(i);
	}
	
	private <T> void foohelper(List<T> i) {
		i.set(0, i.get(0));
	}
}
