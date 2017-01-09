package my.ds;

public class LinkedList {
	Node head;
	
	static class Node {
		int data;
		Node next;
//		Node (int d) {
//			this.data = d;
//		}
	}
	
	public void printList() {
		Node n = head;
		while (n != null) {
			System.out.println(n.data + " ");
			n = n.next;
		}
	}
	
	public Node InsertNth(Node head, int data, int position) {
		   // This is a "method-only" submission. 
		    // You only need to complete this method. 
		    Node tmp = new Node();
		    tmp.data = data;
		    
		    if (head == null && position != 0)
		        return null;
		    
		    if (position == 0) {
		        tmp.next = head;
		        head = tmp;
		        return head;
		    }
		    
		    Node curr = head;
		    int count = position;
		    while (count > 0 && curr.next != null) {
		        curr = curr.next;
		        count--;
		    }
		    tmp.next = curr.next;
		    curr.next = tmp;
		    
		    return head;
		}
	
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		
/*		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		llist.head.next = second;
		second.next = third;
		
		llist.printList();
*/	
		llist.InsertNth(llist.head, 3, 0);
		llist.InsertNth(llist.head, 5, 1);
		llist.InsertNth(llist.head, 4, 2);
		llist.InsertNth(llist.head, 2, 3);
		
		llist.printList();
		
	}
}
