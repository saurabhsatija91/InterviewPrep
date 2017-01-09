package Geeks4geeks;

import java.util.Arrays;

public class QueueUsingArrays<T> {
	private int front;
	private int end;
	int size;
	T[] queue;
	
	@SuppressWarnings("unchecked")
	public QueueUsingArrays (int size) {
		this.size = size;
		this.queue = (T[]) new Object[size];
		front = -1;
		end = -1;
	}
	
	public boolean isEmpty() {
		return (front == -1 && end == -1);
	}
	
	public void enQueue (T value) {
		if ((end + 1) % size == front) {
			throw new IllegalStateException("Queue is full");
		} else if (isEmpty()) {
			front++;
			end++;
			queue[end] = value;
		} else {
			end = (end + 1) % size;
			queue[end] = value;
		}
	}
	
	public T deQueue() {
		T value = null;
		if (isEmpty()) {
			throw new IllegalStateException("Queue is Empty!!");
		} else if (front == end) {
			value = queue[front];
			front = -1;
			end = -1;
		} else {
			value = queue[front];
			front = (front + 1) % size;
		}
		return value;
	}
	
	public String toString() {
		return "Queue [front = " + front + ", rear = " + end +
				", size= " + size + ", queue=" + Arrays.toString(queue) + "]";
	}
	
	public static <T> void main(String[] args) {
        QueueUsingArrays<Integer> newQueue = new QueueUsingArrays<>(5);
        newQueue.enQueue(10);
        newQueue.enQueue(20);
        newQueue.enQueue(30);
        newQueue.enQueue(40);
        newQueue.enQueue(50);
        System.out.println(newQueue.toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.toString());
        newQueue.enQueue(60);
        newQueue.enQueue(70);
        System.out.println(newQueue.toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.deQueue().toString());
        System.out.println(newQueue.toString());


    }

}
