package week3;

public class Stack<T> {
	// field
	private Node<T> top;
	private int size;

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	// push, adds to stack
	public void push(T input) {
		Node<T> newNode = new Node<>(input);
		newNode.next = top;
		top = newNode;
		size++;
		System.out.println("Added: " + input);
	}

	// pop, removes from stack
	public T pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
		}
		T input = top.data;
		top = top.next;
		size--;
		return input;
	}

	// peek, returns top of stack, without removing it
	public T peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
		}
		return top.data;
	}

	// checks if its an empty stack
	public boolean isEmpty() {
		return top == null;
	}

	// returns the size of the stack

	public int size() {
		return size;
	}

}
