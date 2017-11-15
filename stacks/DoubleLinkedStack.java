package stacks;

import java.awt.HeadlessException;

import impls.DoubleLinkedNode;
import interfaces.StackADT;

public class DoubleLinkedStack<T> implements StackADT<T> {

	private int count;
	private DoubleLinkedNode<T> head;
	
	public DoubleLinkedStack() {
		// TODO Auto-generated constructor stub
		head = null;
		count = 0;
	}
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		DoubleLinkedNode<T> temp = new DoubleLinkedNode<>();
		temp.setElement(element);
		temp.setNext(head);
		head = temp;
		count ++;
	}

	@Override
	public T pop() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("stack is empty");
		}
		T result = head.getElement();
		head = head.getNext();
		count--;
		return result;
	}

	@Override
	public T peek() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("stack is empty");
		}
		
		return head.getElement();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0)? true : false;
	}

}
