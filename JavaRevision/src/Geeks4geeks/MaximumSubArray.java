package Geeks4geeks;

public class MaximumSubArray {
	public static int maxSubArray (int[] arr) {
		int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			sum[i] = Math.max(arr[i], sum[i-1] + arr[i]);
			max = Math.max(max, sum[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 2, -1, 3, 1, -2};
		System.out.println(maxSubArray(nums));
	}
}
