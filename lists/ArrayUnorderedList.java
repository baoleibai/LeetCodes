package lists;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import interfaces.unorderedListADT;

public class ArrayUnorderedList<T> extends FixedArrayList<T> implements unorderedListADT<T>{

	@Override
	public void addToFront(T element) throws Exception{
		
		if (rear == list.length) {
			throw new Exception("reach list limits.");
		}
		
		// TODO Auto-generated method stub
		for (int i = rear; i > 0; i --) {
			list[i] = list[i-1];
		}
		list[0] = element;
		rear ++;
	}

	@Override
	public void addToEnd(T element) throws Exception {
		// TODO Auto-generated method stub
		if (rear == list.length) {
			throw new Exception("reach list limits.");
		}
		list[rear] = element;
		rear ++;
	}

	@Override
	public void addAfter(T element, T target) throws Exception {
		// TODO Auto-generated method stub
		if (rear == list.length) {
			throw new Exception("reach list limits.");
		}
		
		if (!contains(target)) {
			throw new Exception("list does not contain this element.");
		}
		
		int index = 0;
		
		while (index < rear && !list[index].equals(target)) {
			index++;
		}
		
		index++;
		for (int i = rear; i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = element;
		rear++;
	}
}
