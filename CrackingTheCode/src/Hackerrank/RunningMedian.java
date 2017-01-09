package Hackerrank;
import java.util.*;

public class RunningMedian {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		float median;
		
		PriorityQueue<Integer> lower = new PriorityQueue<>(n,
			new Comparator<Integer>() {
				@Override
				public int compare(Integer one, Integer two) {
					return two - one;
				}
		});
		
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		
		for (int c : a) {
			if(lower.isEmpty())
				lower.add(c);
			else {
				if(lower.size() > higher.size()) {	//lower is bigger
					if(lower.peek() > c) {
						higher.add(lower.poll());
						lower.add(c);
					} else {
						higher.add(c);
					}
				} else {						//higher is bigger
					Integer p = higher.peek();
					if(p != null && p >= c) {
						lower.add(c);
					} else {
						lower.offer(higher.poll());
						higher.add(c);
					}
				}
			}
			
			int s = lower.size() + higher.size();
			if(s % 2 == 0) {
				median = (lower.peek() + higher.peek()) / 2.0f;
			} else {
				median = (float) lower.peek();
			}
			System.out.println(median);
		}
	}
}
