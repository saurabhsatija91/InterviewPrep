#include <stdlib.h>
#include <stdio.h>

struct node{
	int data;
	struct node *next;
};

struct node *new_node(int data){
	struct node *new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = NULL;
	return new_node;
}

void print_list (struct node *head){
	if(head == NULL)
		return;
	while (head->next != NULL){
		printf("%d \n", head->data);
		head = head->next;
	}
}

void add_to_head(struct node **head, int data){
	struct node * node;
	node = new_node(data);

	node->next = *head;
	*head = node;
}

struct node *del_from_head(struct node **head, int data){
	if (*head == NULL)
		return NULL;
	struct node *curr, *del;
	curr = *head;
	while(curr->next != NULL){
		if(curr->data == data && curr == *head){
			free(curr);
			return NULL;
		}else if(curr->data == data){
			del = curr;
			curr = curr->next;
			free(del);
		}else
			curr = curr->next;
	}
	return *head;
}







/*
uint64_t mask = 0xffff800000000000;

if (address & mask == mask) //Bits 63 to 47 are 1
    return true;
if (((address & mask) ^ mask) == mask)    //Bits 63 to 47 are 0
    return true;

return false;
*/
