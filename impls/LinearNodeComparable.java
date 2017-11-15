package impls;

import java.util.ArrayList;

public class LinearNodeComparable<T> implements Comparable<T>{
	private LinearNodeComparable<T> next;
	private T current;
	
	public LinearNodeComparable() {
		next = null;
		current = null;
	}
	
	public LinearNodeComparable(T element) {
		current = element;
		next = null;
	}
	
	public LinearNodeComparable<T> getNext() {
		return next;
	}
	
	public void setNext(LinearNodeComparable<T> next) {
		this.next = next;
	}
	
	public T getElement() {
		return current;
	}
	
	public void setElement(T element) {
		current = element;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
