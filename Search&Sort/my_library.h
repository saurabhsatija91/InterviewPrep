/*
 * my_libarary.h
 *
 *  Created on: Nov 19, 2016
 *      Author: Saurabh
 */

#ifndef MY_LIBRARY_H_
#define MY_LIBRARY_H_

void swap_int (int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void print_arr (int arr[], int n) {
	for (int i = 0; i < n; i++) {
		printf("%d, ", arr[i]);
	}
	printf("\n");
}

void selection_sort (int arr[], int n) {
	int i, j, min_idx;

	for (i = 0; i < n - 1; i++) {
		min_idx = i;
		for (j = i + 1; j < n - 1; j++) {
			if (arr[j] < arr[min_idx])
				min_idx = j;
		}
		swap_int(&arr[i], &arr[min_idx]);
	}
}

void my_bubblesort(int arr[], int n) {
	int i, j;
	for (i = 0; i < n-1; i++) {
		for (j = 0; j < n - i - 1; j++) {
			if (arr[j] > arr[j+1]) {
				swap_int(&arr[j], &arr[j+1]);
			}
		}
	}
}

void my_insertionsort (int arr[], int n) {
	int i, j, key;

	for (i = 1; i < n; i++) {
		key = arr[i];
		j = i - 1;
		while (j >= 0 && key < arr[j]) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}
}

void countsort (int arr[], int n, int k) {
	int outarr[n];
	int count[k + 1], i;
	memset(count, 0, sizeof(count));

	for (i = 0; i < n; i++) {	//Initialize count arr
		++count[arr[i]];
	}
	for (i = 1; i <= k; i++) {
		count[i] += count[i - 1];
	}
	for (i = 0; i < n; i++) {
		outarr[count[arr[i]] - 1] = arr[i];
		count[arr[i]]--;
	}
	for (i = 0; i < n; i++)
		arr[i] = outarr[i];
}

void merge (int arr[], int l, int m, int r) {
	int i, j, k;
	int n1 = m - l + 1;
	int n2 = r - m;
	int L[n1], R[n2];
	for (i = 0; i < n1; i++) {
		L[i] = arr[l + i];
	}
	for (i = 0; i < n2; i++) {
		R[i] = arr[m + 1 + i];
	}
	i = 0; j = 0; k = l;

	while (i < n1 && j < n2) {
		if (L[i] <= R[j]) {
			arr[k++] = L[i++];
		} else {
			arr[k++] = R[j++];
		}
	}
	while (i < n1)
		arr[k++] = L[i++];
	while (j < n2)
		arr[k++] = R[j++];
}

void merge_sort (int arr[], int l, int r) {
	if (l < r) {
		int mid = l + (r - l) / 2;
		merge_sort(arr, l, mid);
		merge_sort(arr, mid + 1, r);

		merge(arr, l, mid, r);
	}
}

#endif /* MY_LIBRARY_H_ */
