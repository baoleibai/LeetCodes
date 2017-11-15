package impls;

import interfaces.StackADT;

public class DoubleLinkedNode<T> {
	
	private DoubleLinkedNode<T> previous;
	private DoubleLinkedNode<T> next;
	private T element;
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public DoubleLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleLinkedNode<T> next) {
		this.next = next;
	}

	public DoubleLinkedNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleLinkedNode<T> previous) {
		this.previous = previous;
	}
	
	public DoubleLinkedNode() {
		// TODO Auto-generated constructor stub
		next = null;
		previous = null;
	}
}
