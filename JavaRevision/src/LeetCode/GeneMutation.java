package LeetCode;
import java.util.*;

public class GeneMutation {
/*	public int minMutation (String start, String end, String[] bank) {
		if (start.equals(end)) return 0;
		
		Set<String> bankSet = new HashSet<>();
		for (String b : bank) bankSet.add(b);
		
		char[] charSet = new char[] {'A', 'C', 'G', 'T'};
		
		int level = 0;
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String curr = queue.poll();
				if (curr.equals(end)) return level;
				
				char[] currArray = curr.toCharArray();
				for (int i = 0; i < currArray.length; i++) {
					char old = currArray[i];
					for (char c : charSet) {
						currArray[i] = c;
						String next = new String(currArray);
						if (!visited.contains(next) && bankSet.contains(next)) {
							visited.add(next);
							queue.offer(next);
						}
					}
					currArray[i] = old;
				}
			}
			level++;
		}
		return -1;
	}
*/
	int min = -1;
	int deep = 0;
	
	public int minMutations (String start, String end, String[] bank) {
		if (bank == null || bank.length == 0) {
			return -1;
		}
		if (bank == null || bank.length == 0)
			return -1;
		Set<String> bankSet = new HashSet<>();
		for (String s : bank) {
			bankSet.add(s);
		}
		if (!bankSet.contains(end))
			return -1;
		
		mutation(start, end, bankSet);
		return min;
	}
	
	private void mutation(String start, String end, Set<String> bank) {
		if (canChange(start, end)) {
			if (min < 0 || min > deep) {
				min = deep + 1;
			}
			return;
		}
		
		for (Object obj : bank.toArray()) {
			String mid = (String) obj;
			if (canChange(start, end)) {
				bank.remove(mid);
				deep++;
				mutation(mid, end, bank);
				deep--;
				bank.add(mid);
			}
		}
	}
	
	private boolean canChange (String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				diff++;
		}
		return (diff == 1);
 	}
}
