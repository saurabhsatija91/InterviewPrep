package Geeks4geeks;

public class MergeSort {
	public void merge(int[] arr, int l, int m, int h) {
		int n1 = m - l + 1;
		int n2 = h - m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];
		
		for (int i = 0; i < n2; i++)
			R[i] = arr[m + 1 + i];
		
		int i = 0, j = 0, k = l;
		
		while (i < n1 && j < n2) {
			if (L[i] < R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		}
		while (i < n1)
			arr[k++] = L[i++];
		while (j < n2)
			arr[k++] = R[j++];
		
	}
	public void mergeSort (int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			
			mergeSort (arr, low, mid);
			mergeSort (arr, mid + 1, high);
			
			merge(arr, low, mid, high);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 1, 4, 3, 6, 4, 0, 9};
		(new MergeSort()).mergeSort(nums, 0, nums.length - 1);
		for (int a : nums)
			System.out.print(a + " ");
	}
}
