package LeetCode;

import java.util.*;

public class twoSum {
	public int[] twoSumSolution (int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		/*for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}*/
		for (int i = 0; i < nums.length; i++) {
			int comp = target - nums[i];
			if (map.containsKey(comp) && map.get(comp) != i) {
				return new int[] {map.get(comp), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String[] args) {
		twoSum app = new twoSum();
		int[] nums = {2, 4, 3, 7, 5, 9};
		int[] arr = app.twoSumSolution(nums, 7);
		for (int a : arr)
			System.out.print(a + " ");
	}
}
