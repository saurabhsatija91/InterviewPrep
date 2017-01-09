/*
 * tester_code.c
 *
 *  Created on: Nov 19, 2016
 *      Author: Saurabh
 */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "my_library.h"
#include "my_lib_2.h"
#include "sll.h"
#include "str_lib.h"

/*
int main()
{
	int arr[] = {2, 4, 1, 1, 7, 6, 9, 5};
	int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	int n = sizeof(a) / sizeof(a[0]);
	int size = sizeof(arr) / sizeof(arr[0]);
	print_arr(arr, size);
//	selection_sort(arr, size);
//	my_bubblesort(arr, size);
//	my_insertionsort(arr, size);
//	merge_sort(arr, 0, size - 1);
//	countsort(arr, size, 9);
	print_arr(arr, size);
	print_sum_pair(arr, size, 15);

	printf("Max sum: %d\n", max_sum_subarr(a, n));
	printf("Max sum: %d\n", max_sum_subarr2(a, n));
	return 0;
}
*/

/*
int main() {
	struct node *head = NULL;
//	push(&head, 10);
//	push(&head, 30);
//	push(&head, 55);
//	push(&head, 20);
	append_sll(&head, 1);
	insert_after_sll(&head, 1, 25);
	append_sll(&head, 3);
	append_sll(&head, 7);
	append_sll(&head, 4);
	append_sll(&head, 12);
	append_sll(&head, 9);
	print_ll(head);
	delete_sll(&head, 12);
	insert_after_sll(&head, 4, 75);
	insert_after_sll(&head, 9, 50);
	print_ll(head);
	swap_sll (&head, 1, 75);
	print_ll(head);
	reverse_sll(&head);
	print_ll(head);
	head = reverse_sll_grp(head, 3);
	print_ll(head);
}
*/

/*
int main() {
	char *str1 = "Saurabh";
	char *str2 = "Satija";
	char fn[100] = "Saurabh";
	char ln[] = "Satija";
	printf("Str1: %s\nStr2: %s\n", str1, str2);
	swapstr1(&str1, &str2);
	printf("Str1: %s\nStr2: %s\n", str1, str2);

	swapstr2(fn, ln);
	printf("Str1: %s\nStr2: %s\n", fn, ln);

	printf("strlen of str1 = %d", strlen(str1));
	int arr[] = {2, 4, 1, 6, 8, 3, 0};
	char cdest[100];
	int n = sizeof(arr) / sizeof(arr[0]);
	int idest[n];

	my_memcpy(cdest, fn, strlen(fn) + 1); 		//sizeof(fn));
	printf("cdest: %s\n", cdest);

	my_memmove2(fn+3, fn, strlen(fn) + 1);
	printf("new fn: %s\n", fn);

	my_memcpy(idest, arr, sizeof(arr));
	for(int i = 0; i < n; i++) {
		printf("%d ", idest[i]);
	}
	char c = '.';

	printf("\n%c\n", tolower(c));
}
*/

int main() {
	char* S = (char *)malloc(10240 * sizeof(char));
	    scanf("%s",S);
	    int count = 0;
	    char sos[] = "SOS";
	    int len = strlen(S);
	    for (int i = 0; i < len; i++) {
	    	printf("Orig: %c ", *(S+i));
	    	printf("Sample: %c ", sos[i % 3]);
	    	printf("\n");
	        if (*(S + i) != sos[i % 3])
	            count++;
	    }
	    printf("%d", count);

	    if (*(S + 1) == sos[1])
	    	printf("\nyes\n");

	    return 0;
}

/*
int main() {

    int rocks;
    scanf("%d", &rocks);
    char letter[26] = {0};
    int count = 0;
    for (int r = 0; r < rocks; r++) {
        char s[100];
        scanf("%s", s);
        for (int i = 0; i < strlen(s); i++) {
            char c = s[i];
            if (letter[c - 'a'] == r) {
                letter[c - 'a']++;
                if (letter[c - 'a'] == rocks) {
                    count++;
                }
            }
        }
    }

    printf("%d", count);

    return 0;
}*/
