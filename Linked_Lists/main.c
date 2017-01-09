#include "lib2.h"

int main(){
	struct node *list = new_node(0);
	struct node *list2 = new_node(0);
	int i;

	for (i = 10; i > 1; i--) {
		add_to_head ( &list, i);
		add_to_head (&list2, 2 * i);
	}

	printf("Iterative len: %d\n", len_ll_ite(list));
	printf("Recursive len: %d\n", len_ll_rec(list));
	printlist(list);

//	reverse_ll(&list);
	printlist(sorted_ll_rec(list, list2));

	return 0;
}
