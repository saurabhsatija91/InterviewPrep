package lc_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.*;

public class TwoSum {
	//Brute Force
	/*public static int[] twoSum (int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No such indices.");
	}*/
	
	/*//Two-pass Hash Table
	public static int[] twoSum (int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			m.put(nums[i], i);
		}
		for (int i = 0; i < nums.length;  i++) {
			int complement = target - nums[i];
			if (m.containsKey(complement) && m.get(complement) != i)
				return new int[] {i, m.get(complement)};
		}
		throw new IllegalArgumentException("No such indices.");
	}*/
	
	//One-pass Hash Table
	public static int[] twoSum (int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if (map.containsKey(complement))// && map.get(complement) != i)
				return new int[] {map.get(complement), i};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No such indices.");
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 7, 2, 11, 5};
		int target = 10;
		System.out.format("indices for sum = %d is: %s", target, Arrays.toString(twoSum(arr, target)));
	}
}
