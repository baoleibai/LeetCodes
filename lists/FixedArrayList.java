package lists;

import java.util.Iterator;

import impls.ArrayIterator;
import interfaces.ListADT;

public class FixedArrayList<T> implements ListADT<T>, Iterable<T> {

	private static final int DEFAULT_SIZE = 100;
	protected T[] list;
	
	private static final int NOT_FOUND = -1;
	protected int rear;
	
	public FixedArrayList() {
		// TODO Auto-generated constructor stub
		list = (T[]) (new Object[DEFAULT_SIZE]);
		rear = 0;
	}
	
	public FixedArrayList(int size) {
		list = (T[]) (new Object[size]);
		rear = 0;
	}
	
	@Override
	public T removeFirst() throws Exception {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new Exception("array list is empty");
		}
		
		return remove(list[0]);
	}

	@Override
	public T removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("array list is empty");
		}
		return remove(list[rear - 1]);
	}

	@Override
	public T remove(T element) throws Exception {
		// TODO Auto-generated method stub
		T result = null;
		int index = find(element);
		
		if (index == NOT_FOUND) {
			throw new Exception("element not found exception");
		}
		
		result = list[index];
		rear --;
		for (int i = index; i < rear; i ++) {
			list[i] = list[i+1];
		}
		list[rear] = null;
		return result;
	}
	
	private int find(T element) {
		if (!isEmpty()) {
			int scan = 0;
			while (scan < rear) {
				if (element.equals(list[scan])) {
					return scan;
				} else {
					scan++;
				}
			}
		}
		
		return NOT_FOUND;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		
		return list[0];
	}

	@Override
	public T last() {
		if (isEmpty()) {
			return null;
		}
		// TODO Auto-generated method stub
		return list[rear - 1];
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return (find(element) != NOT_FOUND)? true: false; 
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (rear == 0) {
			return true;
		} else {
		 	return false;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return rear;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator<T>(list, rear);
	}
}
