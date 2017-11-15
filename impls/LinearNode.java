package impls;

public class LinearNode<T> {
	private LinearNode<T> next;
	private T current;
	
	public LinearNode() {
		next = null;
		current = null;
	}
	
	public LinearNode(T element) {
		current = element;
		next = null;
	}
	
	public LinearNode<T> getNext() {
		return next;
	}
	
	public void setNext(LinearNode<T> next) {
		this.next = next;
	}
	
	public T getElement() {
		return current;
	}
	
	public void setElement(T element) {
		current = element;
	}
}
