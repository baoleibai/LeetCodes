package lists;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import impls.LinearNode;
import impls.LinkedListIterator;
import interfaces.ListADT;

public class LinkedList<T> implements ListADT<T>, Iterable<T> {

	private int count = 0;
	private LinearNode<T> head, tail;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
		tail = null;
		count = 0;
	}
	
	@Override
	public T removeFirst() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("linked list is empty");
		}
		T element = head.getElement();
		
		head = head.getNext();
		
		count--;
		if (count == 0) {
			tail = null;
			head = null;
		}
		return element;
	}

	@Override
	public T removeLast() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("linked list is empty");
		}
		
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		T element = null;
		if (size() == 1) {
			element = head.getElement();
			head = tail = null;
		} else if (size() == 2) {
			element = tail.getElement();
			head.setNext(null);
			tail = head;
		} else {
			while(!current.getNext().equals(tail)) {
				current = current.getNext();
			}
			tail = current;
			tail.setNext(null);
		}
		count --;
		return element;
	}

	@Override
	public T remove(T element) throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("linked list is empty");
		}
		
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		T target = null;
		boolean found = false;
		while (current != null) {
			if (current.getElement().equals(element)) {
				found = true;
				break;
			}
			
			previous = current;
			current = current.getNext();
		}
		
		if (!found) {
			throw new Exception("element not found in list.");
		}
		target = current.getElement();
		if (size() == 1) {
			head = tail = null;
		} else if (current.equals(head)) {
			head = current.getNext();			
		} else if (current.equals(tail)) {
			tail = previous;
			tail.setNext(null);
		}

		count--;
		return target;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}

	@Override
	public T last() {
		if (isEmpty()) {
			return null;
		}
		// TODO Auto-generated method stub
		return tail.getElement();
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return false;
		}
		Iterator<T> iterator = iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(element)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0) ? true : false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator<>(head);
	}
}
