package impls;

import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T> {

	private int count;
	private int current;
	private T[] items;
	
	public ArrayIterator(T[] collections, int size) {
		// TODO Auto-generated constructor stub
		items = collections;
		count = size;
		current = 0;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (current < count) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T next(){
		// TODO Auto-generated method stub
		if (!hasNext()) {
			return null;
		}
		
		current ++;
		return items[current - 1];
	}

}
