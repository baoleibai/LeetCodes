package stacks;

import interfaces.StackADT;

public class ArrayStack<T> implements StackADT<T> {

	private static final int DEFAULT_CAPACITY = 100;
	
	//represent the next available slot and number of elements
	private int top;
	
	private T[] stack;
	
	public ArrayStack() {
		// TODO Auto-generated constructor stub
		top = 0;
		stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}
	
	public ArrayStack(int size) {
		top = 0;
		stack = (T[]) (new Object[size]);
	}
	
	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		if (size() == stack.length) {
			expandCapacity();
		}
		stack[top] = element;
		top++;
	}

	@Override
	public T pop() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("stack pop operation failed. --stack empty");
		}
		
		top --;
		
		T current = stack[top];
		stack[top] = null;
		
		return current;
	}

	@Override
	public T peek() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("stack pop operation failed. --stack empty");
		}
		
		return stack[top -1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (top == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void expandCapacity() {
		T[] larger = (T[])(new Object[stack.length *2]);
		for (int i = 0; i < stack.length;i++) {
			larger[i] = stack[i];
		}
		stack = larger;
	}
}
