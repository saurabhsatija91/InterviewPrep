#include <stdio.h>
#include <stdlib.h>

/*
struct node{
	void *data;
	struct node *next;
};

void add_to_head(struct node **head, void *new_data, size_t data_size){
	struct node *new_node = (struct node*) malloc(sizeof(struct node));

	new_node->data = malloc(data_size);
	new_node->next = *head;

	int i;
	for(i = 0; i < data_size; i++){
		*(char *)(new_node->data++) = *(char *)new_data++;
	}

	*head = new_node;
}
*/

struct xyz{
	int a;
	int b;
	int c;
};
