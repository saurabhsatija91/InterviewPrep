package Hackerrank;

public class QuickSort {
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int left, int right) {
		if (left >= right)
			return;
		
		int pivot = array[(left + right) / 2];
		int index = partition(array, left, right, pivot);
		quickSort(array, left, index - 1);
		quickSort(array, index, right);
	}
	
	private static int partition (int[] array, int left, int right, int pivot) {
		while(left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(array[left], array[right]);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String[] args) {
		
	}
}
