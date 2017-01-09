#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int my_strcmp(char *a, char *b)
{
	return (*a == *b && *b == '\0')? 0: (*a == *b)? my_strcmp(++a, ++b): 1;
}

int my_strcmp2(char a[], char b[])
{
	int i = 0;
	while(a[i] != '\0'){
		if(b[i] == '\0')
			return 1;
		else{
			if(a[i] < b[i])
				return 1;
			else if(a[i] > b[i])
				return -1;
		}
		i++;
	}
	return 0;
}

void my_strcat(char *dest, const char *src){
	while(*dest){
		dest++;
	}
	while(*src){
		*dest++ = *src++;
	}
}

void my_swap(char **str1, char **str2){
	char *temp;
	temp = *str1;
	*str1 = *str2;
	*str2 = temp;
}

void my_swap2(char a[], char b[])
{
	char *temp;
	temp = (char *)malloc(sizeof(char) * (strlen(a) + 1));
	printf("a = %lu\n", strlen(a));
	strncpy(temp, a, strlen(a));
	strncpy(a, b, strlen(b));
	strncpy(b, temp, strlen(temp));
	free(temp);
}

int my_binarysearch (int arr[], int l, int r, int val) {
	int index = -1;
	while (l <= r) {
		int mid = l + (r - l) / 2;
		if (arr[mid] == val) {
			index = mid;
			return index;
		} else if (arr[mid] < val) {
			l = mid + 1;
		} else {
			r = mid - 1;
		}
	}
	return index;
}

int my_binarysearch2 (int arr[], int l, int r, int val) {
	if (l <= r) {
		int mid = l + (r - l) /2;
		if (arr[mid] == val) {
			return mid;
		} else if (arr[mid] > val) {
			return my_binarysearch2(arr, l, mid - 1, val);
		} else {
			return my_binarysearch2(arr, mid + 1, r, val);
		}
	}
	return -1;
}

int my_interpolation_search (int arr[], int n, int x) {
	int lo = 0, hi = n - 1;
	if (x < arr[lo] || x > arr[hi])
		return -1;

	while (lo <= hi) {
		int pos = lo + (((double) (hi-lo) /(arr[hi]-arr[lo])) * (x - arr[lo]));

		if (arr[pos] == x)
			return pos;
		if (arr[pos] < x)
			lo = pos + 1;
		else
			hi = pos - 1;
	}
	return -1;
}
