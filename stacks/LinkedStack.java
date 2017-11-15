package stacks;

import interfaces.StackADT;
import java.util.Stack;

import impls.LinearNode;

public class LinkedStack<T> implements StackADT<T> {

	private int count;
	private LinearNode<T> top;
	
	public LinkedStack() {
		// TODO Auto-generated constructor stub
		count = 0;
		top = null;
	}
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		LinearNode<T> temp = new LinearNode<T>(element);
		temp.setNext(top);
		top = temp;
		count ++;
	}

	@Override
	public T pop() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("linked stack is empty");
		}
		
		T result = top.getElement();
		top = top.getNext();
		count--;
		return result;
	}

	@Override
	public T peek() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("linked stack is empty");
		}
		
		return top.getElement();
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
