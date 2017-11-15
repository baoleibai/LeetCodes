package impls;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T>{

	private LinearNode<T> current;
	public LinkedListIterator(LinearNode<T> head) {
		// TODO Auto-generated constructor stub
		this.current = head;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (current == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public T next() {
		if (!hasNext()) {
			return null;
		}
		// TODO Auto-generated method stub
		T temp = current.getElement();
		current = current.getNext();	
		return temp;
	}
}
