/*
 ============================================================================
 Name        : First_C_proj.c
 Author      : Saurabh
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void pointertest();

int main(void) {
	int k = 5;
//	printf("!!!Hello World!!!\n"); /* prints !!!Hello World!!! */
//	pointertest();
	printf("Value of k = %d\n", k);
	return EXIT_SUCCESS;
}

void pointertest()
{
	int i = 10;
	int j = 20;
	int *ptr;
	ptr = &i;

	printf("Value of i = %d\n", i);
}
