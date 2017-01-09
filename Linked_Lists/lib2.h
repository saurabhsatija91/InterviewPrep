#include <stdlib.h>
#include <stdio.h>

struct node {
	int data;
	struct node *next;
};

struct node *new_node(int data){
	struct node *new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = NULL;

	return new_node;
}

int printlist (struct node *head){
	while (head != NULL){
		printf("%d\t", head->data);
		head = head->next;
	}

	printf("\n");
	return 0;
}

void add_to_head (struct node **head, int data) {
	struct node *new = new_node(data);

	new->next = *head;
	*head = new;
}

void del_data(struct node **head, int data) {
	struct node *ptr = *head, *prev;

	if (ptr != NULL && ptr->data == data) {
		*head = ptr->next;
		free(ptr);
	}

	while (ptr != NULL && ptr->data != data) {
		prev = ptr;
		ptr = ptr->next;
	}
	if (ptr == NULL)
		return;
	prev->next = ptr->next;
	free(ptr);

}

int len_ll_ite (struct node *head) {
	int i = 0;

	if(head == NULL)
		return 0;

	while (head != NULL) {
		i++;
		head = head->next;
	}
	return i;
}

int len_ll_rec (struct node *head) {
	if (head == NULL)
		return 0;
	else return 1 + len_ll_rec(head->next);
}

void reverse_ll (struct  node **head) {
	struct node *prev, *curr, *next;
	curr = *head;
	prev = NULL;

	while (curr != NULL) {
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	*head = prev;
}

void move_node (struct node **dest, struct node **src) {
	struct node *temp = *src;
	*src = (*src)->next;
	(*dest)->next = temp;
	*dest = temp;
}

struct node* sorted_ll_dummy (struct node *a, struct node *b) {
	struct node dummy;
	struct node *tail = &dummy;
	dummy.next = NULL;

	while (a != NULL && b != NULL) {
		if (a->data >= b->data)
			move_node(&tail, &a);
		else if (a->data < b->data)
			move_node(&tail, &b);

		printf("in here\n");
	}
	if (a == NULL)
		tail->next = b;
	else if (b == NULL)
		tail->next = a;

	return tail->next;
}

struct node * sorted_ll_rec (struct node *a, struct node *b) {
	struct node *result = NULL;

	if (a == NULL)
		return b;
	else if (b == NULL)
		return a;

	if (a->data <= b->data) {
		result = a;
		result->next = sorted_ll_rec(a->next, b);
	}
	else if (a->data > b->data) {
		result = b;
		result->next = sorted_ll_rec(a, b->next);
	}
	return result;
}
