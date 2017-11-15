package queues;

import java.lang.reflect.Array;
import java.util.Arrays;

import interfaces.QueueADT;

public class CircularArrayQueue<T> implements QueueADT<T> {
	private static final int DEFAULT_CAPACITY = 100;

	private int count = 0;
	private int head, tail = 0;

	private T[] circularArray;

	public CircularArrayQueue() {
		// TODO Auto-generated constructor stub
		circularArray = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public CircularArrayQueue(int size) {
		circularArray = (T[]) (new Object[size]);
	}

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		if (count == circularArray.length) {
			expandCapacity();
		}

		circularArray[tail] = element;
		tail = (tail + 1) % circularArray.length;
		count++;
	}

	@Override
	public T dequeue() throws Exception {
		// TODO Auto-generated method stub

		if (isEmpty()) {
			throw new Exception("queue is empty");
		}

		T element = circularArray[head];
		circularArray[head] = null;
		head = (head + 1) % circularArray.length;
		count--;
		return element;
	}

	@Override
	public T front() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("queue is empty");
		}

		return circularArray[head];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0) ? true : false;
	}

	private void expandCapacity() {
		T[] larger = (T[]) (new Object[circularArray.length * 2]);
		
		for (int i = 0; i < count; i++) {
			larger[i] = circularArray[head];
			head = (head + 1) % circularArray.length;
		}
		head = 0;
		tail = count;
		circularArray = larger;
	}
}
