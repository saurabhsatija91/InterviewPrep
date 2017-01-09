/*
 * sll.h
 *
 *  Created on: Nov 20, 2016
 *      Author: Saurabh
 */
#include <stdlib.h>

#ifndef SLL_H_
#define SLL_H_

struct node {
	int data;
	struct node *next;
};

void push (struct node **head, int data) {
	struct node *tmp = (struct node *) malloc (sizeof(struct node));
	tmp->data = data;
	tmp->next = *head;
	*head = tmp;
}

void print_ll (struct node *head) {
	while (head != NULL) {
		printf("%d ", head->data);
		head = head->next;
	}
	printf("\n");
}

void append_sll (struct node **head, int new_data) {
	struct node *curr = *head;
	struct node *tmp = (struct node *) malloc(sizeof(struct node));
	tmp->data = new_data;
	tmp->next = NULL;
	if (*head == NULL) {
		*head = tmp;
	} else {
		while (curr->next != NULL)
			curr = curr->next;
		curr->next = tmp;
	}
}

void insert_after_sll (struct node **head, int data, int new_data) {
	struct node *curr = *head;
	if (*head == NULL) {
		printf("Empty list.\n");
		return;
	}
	struct node *tmp = (struct node*) malloc(sizeof(struct node));
	if ((*head)->data == data) {
		tmp->data = new_data;
		tmp->next = (*head)->next;
		(*head)->next = tmp;
	} else {
		while (curr->next != NULL && curr->data != data) {
			curr = curr->next;
		}
		if (curr->data == data) {
			tmp->data = new_data;
			tmp->next = curr->next;
			curr->next = tmp;
		} else {
			printf("\nNo such data.\n");
		}
	}

}

void delete_sll (struct node **head, int key) {
	if (*head == NULL)
		return;
	if ((*head)->data == key) {
		struct node *del = *head;
		*head = (*head)->next;
		free(del);
		del = NULL;
	} else {
		struct node *del = *head;
		struct node *prev = NULL;
		while (del->next && del->data != key) {
			prev = del;
			del = del->next;
		}
		if (del->data) {
			prev->next = del->next;
			free(del);
			del = NULL;
		} else {
			printf("Key not found.\n");
		}
	}
}

void swap_sll (struct node **head, int x, int y) {
	if (x == y)	return;

	if ((*head)->next == NULL) return;
	struct node *prev_x, *curr_x, *prev_y, *curr_y;
	prev_x = NULL;
	prev_y = NULL;
	curr_x = *head;
	curr_y = *head;
	while (curr_x->next != NULL && curr_x->data != x) {
		prev_x = curr_x;
		curr_x = curr_x->next;
	}
	while (curr_y->next != NULL && curr_y->data != y) {
		prev_y = curr_y;
		curr_y = curr_y->next;
	}

	if (curr_x == NULL || curr_y == NULL)
		return;
	struct node *tmp = curr_y->next;

	if (prev_x != NULL) {
		prev_x->next = curr_y;
	} else
		*head = curr_y;

	if (prev_y != NULL) {
		prev_y->next = curr_x;
	} else
		*head = curr_x;

	curr_y->next  = curr_x->next;
	curr_x->next = tmp;
}

void reverse_sll (struct node **head) {
	struct node *prev, *curr, *next;
	prev = NULL;
	curr = *head;
	next = NULL;
	while (curr != NULL) {
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	*head = prev;
}

struct node *reverse_sll_grp (struct node *head, int k) {
	struct node *curr, *prev, *next;
	int count = 0;
	prev = NULL; curr = head; next = NULL;

	while (curr != NULL && count < k) {
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
		count++;
	}
	if (next != NULL) {
		head->next = reverse_sll_grp (next, k);
	}
	return prev;
}
#endif /* SLL_H_ */
