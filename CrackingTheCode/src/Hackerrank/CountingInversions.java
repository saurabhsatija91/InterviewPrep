package Hackerrank;

public class CountingInversions {
	public static int countInversions(int[] arr) {
		int[] aux = arr.clone();
		return mergeSort(arr, 0, arr.length - 1, aux);
	}
	
	public static int mergeSort(int[] arr, int left, int right, int[] aux) {
		if(left == right)
			return 0;
		
		int mid = left + (right - left) / 2;
		int count = 0;
		count += mergeSort(arr, left, mid, aux);
		count += mergeSort(arr, mid + 1, right, aux);
		count += merge(arr, left, right, mid, aux);
		
		return count; 
	}
	
	public static int merge(int[] arr, int left, int right, int mid, int[] aux) {
		int count = 0;
		int i = left;
		int j = mid + 1;
		int k = left;
		
		while (i <= mid || j <= right) {
			if (i > mid)
				arr[k++] = aux[j++];
			else if (j > right) {
				arr[k++] = aux[i++];
			}
			else if (aux[i] <= aux[j]) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
				count += mid - i + 1;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 5};
		System.out.println(countInversions(arr));
	}
}
