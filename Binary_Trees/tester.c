/*
 * tester.c
 *
 *  Created on: Dec 4, 2016
 *      Author: Saurabh
 */

#include <stdio.h>
#include <stdlib.h>
#include "binary_tree.h"
#include "bt_library_1.h"
#include "bst.h"

int main() {
/*	int target;
	my_bt *root = new_node(1);
	root->left = new_node(2);
	root->right = new_node(3);

	root->left->left = new_node(4);
	root->left->right = new_node(5);

	root->right->left = new_node(6);
	root->right->right = new_node(7);

	printf("Preorder:  ");
	print_preorder(root);
	printf("\n");

	printf("Inorder:  ");
	print_inorder(root);
	printf("\n");

	printf("Postorder:  ");
	print_postorder(root);
	printf("\n");

	print_level_order(root);

	target = 4;
	printf("Ancestor of [%d] is: ", target);
	print_ancestors(root, target);*/
	struct bst *root = new_bst(50);
	insert_bst(&root, 30);
	insert_bst(&root, 70);
	insert_bst(&root, 20);
	insert_bst(&root, 60);
	insert_bst(&root, 40);
	insert_bst(&root, 80);
	print_inorder((struct node *)root);
	printf("\n>>> Delete\n");
	root = delete_bst(root, 50);
	print_inorder((struct node *)root);
	printf("\nis bst: %d\n", is_bst(root));
}
