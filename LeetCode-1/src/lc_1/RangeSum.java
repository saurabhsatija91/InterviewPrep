package lc_1;

import java.util.Collection;
import java.util.*;
import java.util.Map;

public class RangeSum {
	private int[] sum;
	private void numArray (int[] nums) {
		sum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++)
			sum[i + 1] = sum[i] + nums[i];
	}
	
	public int rangeSum (int[] nums, int i, int j) {
		this.numArray(nums);
		return sum[j + 1] - sum[i];
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 1, 8, 6};
		System.out.println(new RangeSum().rangeSum(arr, 2, 5));
	}
}
