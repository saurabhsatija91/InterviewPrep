package Geeks4geeks;

import java.util.Arrays;
import java.util.*;

public class KthLargestElement {

	// Sorting, O(n logn)
	public static int findKthLargest (int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k - 1];
	}
	
	// Using HEAP O(n log(k) )
	public static int findKthLargestElem (int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);
		for (int i : nums) {
			queue.offer(i);
			System.out.println(">>> " + queue);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.peek();
	}
	
	// Quick Select, Avg case O(n), Worst case O(n^2)
	public static int findKthLargestElement (int[] nums, int k) {
		if (k < 1 || nums == null)
			return 0;
		
		return getKth (nums.length - k + 1, nums, 0, nums.length - 1);
	}
	
	protected static int getKth (int k, int[] nums, int start, int end) {
		int pivot = nums[end];
		
		int left = start;
		int right = end;
		
		while (true) {
			while (nums[left] < pivot && left < right) {
				left++;
			}
			while (nums[right] >= pivot && left < right) {
				right--;
			}
			if (left == right)
				break;
			
			swap (nums, left, right);
		}
		
		swap (nums, left, end);
		if (k == left + 1)
			return pivot;
		else if (k < left + 1) {
			return getKth(k, nums, start, left -1);
		} else
			return getKth(k, nums, left + 1, end);
	}
	
	public static void swap (int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 3, 6, 1, 9, 7};
		System.out.println("3rd largest: " + findKthLargestElem(nums, 3));
	}
}
