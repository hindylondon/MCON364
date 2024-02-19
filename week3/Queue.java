package week3;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> implements QueueInterface<T> {
	// fields
	private List<T> list;
	private int head;
	private int queueLen;

	// Constructor
	public Queue() {
		list = new ArrayList<T>();
		head = 0;
		queueLen = 0;
	}

	// add elements to the queue
	@Override
	public void enqueue(T element) {
		list.add(element);
		queueLen++;
	}

	// remove elements from the queue
	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T removed = null;
		removed = list.get(head);
		head = (head + 1) % list.size();
		queueLen--;
		if (queueLen == 0) {
			head = 0;
		}

		return removed;
	}

	// display what is first on the queue
	@Override
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return list.get(head);
	}

	// check if queue is empty
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	// size of queue
	@Override
	public int size() {
		return list.size();
	}

	// empty the queue
	@Override
	public void clear() {
		list.clear();
		head = 0;
	}

	@Override
	// Printing only the active members in the queue
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("These are the contents of the queue head : \n" + head);

		for (int i = head; i < queueLen; i++) {
			if (list.get(i) != null) {
				stringBuffer.append(i);
				stringBuffer.append(" : ");
				stringBuffer.append(list.get(i));
				stringBuffer.append("\n");

			}
		}
		return stringBuffer.toString();
	}
}
