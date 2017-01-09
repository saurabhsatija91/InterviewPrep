package Geeks4geeks;

public class LongestPalindromeSubstring {
	public String longestPalindrome(String string) {
		if (string == null || string.length() <= 1)
			return string;
		
		int len = string.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];
		String longest = null;
		for (int l = 0; l < string.length(); l++) {
			for (int i = 0; i < len - 1; i++) {
				int j = i+1;
				
				if (string.charAt(i) == string.charAt(j) &&
						(j-i <= 2 || dp[i+1][j-1])) {
					dp[i][j] = true;
					
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						longest = string.substring(i, j + 1);
					}
				}
			}
		}
		return longest;
	}
	
	public String longestPalindromeStr (String string) {
		if (string.isEmpty())
			return null;
		if (string.length() == 1)
			return string;
		
		String longest = string.substring(0, 1);
		
		for (int i = 0; i < string.length(); i++) {
			String tmp = helper(string, i, i);
			if (tmp.length() > longest.length())
				longest = tmp;
			
			tmp = helper(string, i, i+1);
			if (tmp.length() > longest.length())
				longest = tmp;
		}
		
		return longest;
	}
	public String helper (String str, int begin, int end) {
		while (begin >= 0 && end <= str.length() - 1 && str.charAt(begin)
				== str.charAt(end)) {
			begin--;
			end++;
		}
		return str.substring (begin + 1, end);
	}
}
