/*
 * bst.h
 *
 *  Created on: Dec 6, 2016
 *      Author: Saurabh
 */
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#ifndef BST_H_
#define BST_H_

struct bst {
	int key;
	struct bst *left, *right;
};

struct bst *new_bst (int val) {
	struct bst *tmp = (struct bst *) malloc (sizeof(struct bst));
	tmp->key = val;
	tmp->left = NULL;
	tmp->right = NULL;

	return tmp;
}

void insert_bst (struct bst **root, int key) {
	if ((*root) == NULL)
		*root = new_bst(key);
	if (key < (*root)->key) {
		insert_bst (&(*root)->left, key);
	} else if (key > (*root)->key) {
		insert_bst (&(*root)->right, key);
	}
}

struct bst *_min_value_node (struct bst *root) {
	while (root->left != NULL)
		root = root->left;
	return root;
}

struct bst *delete_bst (struct bst *root, int key) {
	if (root == NULL) return root;

	if (key < root->key) {
		root->left = delete_bst(root->left, key);
	} else if (key > root->key)
		root->right = delete_bst(root->right, key);
	else {
		if (root->left == NULL){
			struct bst *tmp = root->right;
			free(root);
			return tmp;
		}
		else if (root->right == NULL) {
			struct bst *tmp = root->left;
			free(root);
			return tmp;
		}

		struct bst *tmp = _min_value_node (root->right);
		root->key = tmp->key;

		root->right = delete_bst(root->right, tmp->key);
	}
	return root;
}

int _is_bst (struct bst *node, int min, int max) {
	if (node == NULL)
		return 1;
	if (node->key < min || node->key > max)
		return 0;

	return (_is_bst(node->left, min, node->key - 1) &&
			_is_bst(node->right, node->key + 1, max));
}

int is_bst (struct bst *root) {
	return (_is_bst(root, INT_MIN, INT_MAX));
}

void merge_bst (struct bst *root1, struct bst *root2) {
	struct stack *s1;
	struct bst* curr1 = root1;

	struct stack *s2;
	struct bst *curr2 = root2;

	if (root1 == NULL) {
		print_inorder(root2);
		return;
	}
	if (root2 == NULL) {
		print_inorder(root1);
		return;
	}
}

#endif /* BST_H_ */
