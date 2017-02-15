package Hackerrank;

public class DelForAnagram {
	public int numberNeeded(String first, String second) {
		int[] letters = new int[26];
		int delete = 0;
		
		for (char c : first.toLowerCase().toCharArray()) {
			letters[c - 'a']++;
		}
		for (char c : second.toLowerCase().toCharArray()) {
			letters[c - 'a']--;
		}
		for (int i : letters) {
			delete += Math.abs(i);
		}
		
		return delete;
	}
}
