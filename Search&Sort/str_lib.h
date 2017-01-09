/*
 * str_lib.h
 *
 *  Created on: Nov 21, 2016
 *      Author: Saurabh
 */

#ifndef STR_LIB_H_
#define STR_LIB_H_
#include <string.h>

void swapstr1 (char **str1, char **str2) {
	char *tmp;
	tmp = *str2;
	*str2 = *str1;
	*str1 = tmp;
}

void swapstr2 (char *str1, char *str2) {
	char *tmp = (char *) malloc(sizeof(str1));
	strncpy(tmp, str1, strlen(str1) + 1);
	strncpy(str1, str2, strlen(str2) + 1);
	strncpy(str2, tmp, strlen(tmp) + 1);
	free(tmp);
}

void my_memcpy (void *dest, void *src, size_t n) {
	char *cdest = (char *)dest;
	char *csrc = (char *) src;
	for (int i = 0; i < n; i++) {
		cdest[i] = csrc[i];
	}
}

void my_memmove (void *dest, void *src, size_t n) {
	char *cdest = (char *)dest;
	char *csrc = (char *)src;
	char temp[n];
	for (int i = 0; i < n; i++)
		temp[i] = csrc[i];
	for (int i = 0; i < n; i++)
		cdest[i] = temp[i];
}

void my_memmove2 (void *dest, void *src, size_t n) {
	char *cdest = (char *)dest;
	char *csrc = (char *)src;

	if (cdest > csrc && cdest < (csrc + n)) {
		for (int i = n - 1; i >= 0; i--) {
			cdest[i] = csrc[i];
		}
	} else {
		for (int i = 0; i < n; i++)
				cdest[i] = csrc[i];
	}
}
#endif /* STR_LIB_H_ */
