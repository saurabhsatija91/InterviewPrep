/*
 * main.c
 *
 *  Created on: Nov 17, 2016
 *      Author: Saurabh
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define NO_OF_CHARS 26

//To represent list node for indexes of words in
//the given sequence. the list nodes are used to connect
//anagrams at leaf nodes of trie.
struct IndexNode
{
	int index;
	struct IndexNode* next;
};

struct TrieNode
{
	bool isEnd;
	struct TrieNode* child[NO_OF_CHARS]; //26 slots each for a to z.
	struct IndexNode* head; //head of the index node.
};

struct TrieNode* newTrieNode() {
	struct TrieNode* tmp = new TrieNode();
	tmp->isEnd = 0;
	tmp->head = NULL;
	for (int i = 0; i < NO_OF_CHARS; i++) {
		tmp->child[i] = NULL;
	}
	return tmp;
}

struct IndexNode* newIndexNode(int index)
{
	struct IndexNode* tmp = new IndexNode();
	tmp->index = index;
	tmp->next = NULL;
	return tmp;
}

int compare(const void* a, const void* b) {
	return (*(char *)a - *(char *)b);
}

//Utility func to insert a word in to Trie.
void insert(struct TrieNode** root, char* word, int index)
{
	if (*root == NULL) {
		*root = new newTrieNode();
	}
	if (*word != '\0')
		insert( &((*root) -> child[tolower(*word) - 'a']), word+1, index);
	else //if end of word has reached
	{
		//Insert index of this word to end of index linked list
		if ((*root) -> isEnd)
		{
			IndexNode* pCrawl = (*root) -> head;
		}
	}
}























