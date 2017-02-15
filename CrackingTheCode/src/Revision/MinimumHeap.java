package Revision;

import java.util.Arrays;

public class MinimumHeap {
	private int capacity = 10;
	private int size = 0;
	
	int[] items = new int[capacity];
	
	private int getLeftChildIndex (int parentIndex) {
		return (2 * parentIndex) + 1;
	}
	private int getRightChildIndex (int parentIndex) {
		return (2 * parentIndex) + 2;
	}
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild (int index) {
		return (getLeftChildIndex(index) < size);
	}
	private boolean hasRightChild (int index) {
		return (getRightChildIndex(index) < size);
	}
	private boolean hasParent(int index) {
		return (getParentIndex(index) >= 0);
	}
	
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	private int rightChild (int index) {
		return items[getRightChildIndex(index)];
	}
	private int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	private void swap (int a, int b) {
		int temp = items[b];
		items[b] = items[a];
		items[a] = temp;
	}
	
	private void ensureCapacity () {
		if (size == capacity) {
			items = Arrays.copyOf(items, 2 * capacity);
			capacity = 2 * capacity;
		}
	}
	
	private int peek () {
		if (size == 0)
			throw new IllegalStateException();
		return items[0];
	}
	
	public int poll () {
		if (size == 0)
			throw new IllegalStateException();
		int ret = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return ret;
	}
	
	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < items[smallerChildIndex]) {
				smallerChildIndex = getRightChildIndex(index);
			}
			if (items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	public void add (int num) {
		ensureCapacity();
		items[size] = num;
		size++;
		heapifyUp();
	}
	
	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index) > items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
 }































