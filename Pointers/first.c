#include <stdio.h>
#include <stdlib.h>

#include "mystrings.h"

void my_startup(void) __attribute__ ((constructor));

void my_startup(void){
	printf("He He \n");
}

void func (void (*foo)(void)){
	printf("This is a callback function func. \n");
	foo();
}

void func2 (void){
	printf("Second callback.\n");
}

int str_compare (char *a, char *b) {
	return (*a == *b && *b == '\0') ? 0 : (*a == *b) ? str_compare(++a, ++b) : (*b - *a);
}

/*
int main()
{
	char one[10], two[10];
	char src[50], dest[50];
	void (*func_ptr)(void (*foo) (void));
	func_ptr = func;
	void (*fp2) (void) = &func2;
	my_swap(&one, &two);
	printf("one: %s\t two: %s.\n", one, two);
	func_ptr(fp2);
	printf("ret: %d\n", str_compare("abcd", "abcf"));
	printf("ret: %d\n", my_strcmp("abcd", "abc"));

	strcpy(dest, "This is ");
	strcpy(src, "the remaining.");
	strcpy(one, "Saurabh");
	strcpy(two, "Satija");
	my_strcat(dest, src);

	printf("Concat: %s\n\n", dest);

	printf("One: %s, Two: %s\n", one, two);
	my_swap(one, two);
	printf("One: %s, Two: %s\n", one, two);
	my_swap2(one, two);
	printf("One: %s, Two: %s\n", one, two);

	return 0;
}
*/

int main() {
	int arr[] = {2, 3, 5, 7, 12, 15, 19, 20};
	int val = 5;
	printf ("Index of val= %d is %d\n", val,
			my_binarysearch(arr, 0, (sizeof(arr) / sizeof(arr[0]) - 1), val));
	printf ("Index of val= %d is %d\n", val,
			my_binarysearch2(arr, 0, (sizeof(arr) / sizeof(arr[0]) - 1), val));

	printf ("Index of val= %d is %d\n", val,
				my_interpolation_search(arr, (sizeof(arr) / sizeof(arr[0])), val));
	return 0;
}


