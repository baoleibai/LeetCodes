package lists;

import java.util.Iterator;
import java.util.Vector;

import interfaces.ListADT;
import interfaces.orderListADT;

public class ArrayOrderedList<T extends Comparable<T>> extends FixedArrayList<T >implements orderListADT<T>  {

	
	@Override
	public void add(T element) {
		if (isEmpty()) {
			//expandCapacity();
		}
		
		Comparable<T> temp = (Comparable<T>)element;
		
		int index = 0;
		
		while (index < rear && temp.compareTo(list[index]) > 0) {
			index++;
		}
		
		
		for (int i = rear; i > index; i--) {
			list[i] = list[i-1];
		}
		list[index] = (T)temp;
		rear++;
	}
}
