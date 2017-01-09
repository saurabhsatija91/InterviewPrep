/*
 * binary_tree.h
 *
 *  Created on: Dec 4, 2016
 *      Author: Saurabh
 */
#include <stdlib.h>
#include <stdio.h>

#ifndef BINARY_TREE_H_
#define BINARY_TREE_H_
#define MAX_Q_SIZE 500

typedef struct node {
	int data;
	struct node *left;
	struct node *right;
} my_bt;

struct node *new_node (int data) {
	struct node *node = (struct node*) malloc(sizeof(struct node));
	node->data = data;
	node->left = NULL;
	node->right = NULL;

	return node;
}

void print_preorder (struct node *root) {
	if (root == NULL) {
		return;
	}
	printf("%d, ", root->data);
	print_preorder(root->left);
	print_preorder(root->right);
}

void print_postorder (struct node *root) {
	if (root == NULL) {
		return;
	}
	print_postorder(root->left);
	print_postorder(root->right);
	printf("%d, ", root->data);
}

void print_inorder (struct node *root) {
	if (root == NULL) {
		return;
	}
	print_inorder(root->left);
	printf("%d, ", root->data);
	print_inorder(root->right);
}

int _height_of_bt (struct node *root) {
	if (root == NULL)
		return 0;
	else {
		int lheight = _height_of_bt(root->left);
		int rheight = _height_of_bt(root->right);
		if (lheight > rheight)
			return (lheight + 1);
		else
			return (rheight + 1);
	}
}

void _print_given_level (struct node *root, int level) {
	if (root == NULL)
		return;
	if (level == 1) {
		printf("%d, ", root->data);
	} else if (level > 1) {
		_print_given_level (root->left, level - 1);
		_print_given_level (root->right, level - 1);
	}
}

void print_level_order (struct node *root) {
	int h = _height_of_bt(root);
	printf("height: %d\n", h);
	for (int i = 1; i <= h; i++) {
		_print_given_level (root, i);
		printf("\n");
	}
	printf("\n");
}

//Another DFS implementation
struct node **create_queue (int *front, int *rear) {
	struct node **queue =
			(struct node **) malloc (sizeof(struct node *) * MAX_Q_SIZE);
	*front = *rear = 0;
	return queue;
}

void en_queue (struct node **queue, int *rear, struct node *new_node) {
	queue[*rear] = new_node;
	(*rear)++;
}

struct node *de_queue (struct node **queue, int *front) {
	(*front)++;
	return queue[*front - 1];
}

void print_DFS (struct node *root) {
	int rear, front;
	struct node **queue = create_queue(&front, &rear);
	struct node *tmp_node = root;

	while (tmp_node) {
		printf("%d, ", tmp_node->data);

		if (tmp_node->left)
			en_queue(queue, &rear, tmp_node->left);
		if (tmp_node->right)
			en_queue(queue, &rear, tmp_node->right);
		tmp_node = de_queue(queue, &front);
	}
}

#endif /* BINARY_TREE_H_ */
