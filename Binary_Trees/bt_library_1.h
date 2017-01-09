/*
 * bt_library_1.h
 *
 *  Created on: Dec 5, 2016
 *      Author: Saurabh
 */

#include <stdlib.h>
#include <stdio.h>

typedef enum {false, true} bool;

#ifndef BT_LIBRARY_1_H_
#define BT_LIBRARY_1_H_

/*void inorder (struct node *root) {
	struct node *current = root;
	struct stack_node *stack = NULL;
	bool done = 0;

	while (!done) {
		if (current != NULL) {
			push (&stack, current);
			current = current->left;
		} else {
			if (!isEmpty(stack)) {
				current = pop(stack);
				printf("%d, ", current->data);
				current = current->right;
			}
			else
				done = 1;
		}
	}
}*/

bool print_ancestors (struct node *root, int target) {
	if (root == NULL) {
		return false;
	}
	if (root->data == target) {
		return true;
	}
	if ( print_ancestors(root->left, target) || print_ancestors(root->right, target) ) {
		printf("%d ", root->data);
		return true;
	}

	return false;
}

#endif /* BT_LIBRARY_1_H_ */
