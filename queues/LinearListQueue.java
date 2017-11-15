package queues;

import java.util.concurrent.CountDownLatch;

import impls.LinearNode;
import interfaces.QueueADT;

public class LinearListQueue<T> implements QueueADT<T>{

	private int count = 0;
	private LinearNode<T> head, tail;
	
	public LinearListQueue() {
		head = tail = null;
	}
	
	/**
	 * enqueue at the tail of the single linked list, dequque at the head.
	 */
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		LinearNode<T> temp = new LinearNode<>(element);
		
		if (isEmpty()) {
			head = temp;
		} else {
			tail.setNext(temp);
		}
		
		tail = temp;
		count ++;
	}

	@Override
	public T dequeue() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("queue is empty");
		}
		
		LinearNode<T> temp = head.getNext();
		T current = head.getElement();
		
		head = temp;
		count --;
		if (isEmpty()) {
			tail = null;
		}
		return current;
	}

	@Override
	public T front() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("queue is empty");
		}
		T current = head.getElement();
		
		return current;
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

}
