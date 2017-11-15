package interfaces;

public interface unorderedListADT<T> extends ListADT<T>{
	public void addToFront(T element) throws Exception;
	public void addToEnd(T element) throws Exception;
	public void addAfter(T element, T target) throws Exception;
}
