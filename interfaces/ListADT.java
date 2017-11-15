package interfaces;

import java.util.Iterator;

public interface ListADT<T> extends Iterable<T> {
	
	public T removeFirst() throws Exception;
	public T removeLast() throws Exception;
	
	public T remove(T element) throws Exception;
	
	public T first();
	public T last();
	
	public boolean contains(T element);
	
	public boolean isEmpty();
	
	public int size();
	
	public Iterator<T> iterator();
	
	public String toString();
}
