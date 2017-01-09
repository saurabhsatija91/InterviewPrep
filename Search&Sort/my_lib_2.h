/*
 * my_lib_2.h
 *
 *  Created on: Nov 20, 2016
 *      Author: Saurabh
 */

#ifndef MY_LIB_2_H_
#define MY_LIB_2_H_
#define MAX 1000
void print_sum_pair (int arr[], int arr_sz, int sum) {
	int i, tmp;
	int bin_map[MAX] = {0};

	for (i = 0; i < arr_sz; i++) {
		tmp = sum - arr[i];
		if (tmp > 0 && bin_map[tmp] == 1) {
			printf("Pair for sum=%d is (%d, %d)\n",
					sum, arr[i], tmp);
		}
		bin_map[arr[i]] = 1;
	}
}

int max_sum_subarr (int arr[], int n) {
	int i, max_so_far = 0, max_ending_here = 0;
	for(i = 0; i < n; i++) {
		max_ending_here += arr[i];
		if (max_ending_here < 0)
			max_ending_here = 0;
		if (max_so_far < max_ending_here)
			max_so_far = max_ending_here;
	}

	return max_so_far;
}

int max_sum_subarr2 (int arr[], int n) {
	int i;
	int max_so_far = arr[0];
	int curr_max = arr[0];
	for (i = 1; i < n; i++) {
		curr_max = (arr[i] > curr_max + arr[i]) ? arr[i] : curr_max + arr[i];
		max_so_far = (max_so_far > curr_max) ? max_so_far : curr_max;
	}
	return max_so_far;
}

int find_pivot (int arr[], int lo, int hi) {
	if (hi < lo) return -1;
	if (hi == lo) return lo;

	int mid = lo + (hi - lo) / 2;
	if (mid < hi && arr[mid] > arr[mid + 1])
		return mid;
	if (mid > lo && arr[mid] < arr[mid - 1])
		return mid - 1;
	if (arr[lo] >= arr[mid])
		return find_pivot(arr, lo, mid - 1);
	return find_pivot(arr, mid + 1, hi);
}

/*int pivoted_binarysearch (int arr[], int n, int key) {
	int pivot = find_pivot(arr, 0, n - 1);
	if (pivot == -1)
		binarysearch(arr, 0, n-1, key);
	if (arr[pivot] == key) {
		return pivot;
	}
	if (arr[0] <= key)
		return binarysearch(arr, 0, pivot-1, key);
	return binarysearch(arr, pivot+1, n-1, key);
}*/

int max_sum_no_adj (int arr[], int n) {
	int inc = arr[0];
	int exc = 0;
	int exc_new;
	int i;
	for (i = 0; i < n; i++) {
		exc_new = (inc > exc) ? inc : exc;
		inc = exc + arr[i];
		exc = exc_new;
	}
	return ((inc > exc) ? inc : exc);
}

#endif /* MY_LIB_2_H_ */
