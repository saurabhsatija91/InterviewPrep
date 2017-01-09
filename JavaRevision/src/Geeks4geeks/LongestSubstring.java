package Geeks4geeks;

import java.util.Arrays;

public class LongestSubstring {
	public static String longestRepeatingSubstring (String string) {
		int n = string.length();
		System.out.println("n: " +n);
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++) {
			suffixes[i] = string.substring(i, n);
		}
		
		Arrays.sort(suffixes);
		System.out.println("Suffixes: ");
		for (int ind = 0; ind < n; ind++)
			System.out.println("[ " + ind +" ] " + suffixes[ind]);
		
		String lrs = "";
		for (int i = 0; i < n-1; i++) {
			String[] strs = {suffixes[i], suffixes[i+1]};
			String x = LongestCommonPrefix.longestCommonPrefix(strs);
			System.out.println("[ x @ " + i + " ]" + x);
			if (x.length() > lrs.length())
				lrs = x;
		}
		return lrs;
	}
	
	public static void main(String[] args) {
		System.out.println(longestRepeatingSubstring("abdcjkgabdcgla"));
	/*	String str = "abdcjkgabdcgla";
		int n = str.length();
		System.out.println(str.substring(1, n));*/
	}
}
