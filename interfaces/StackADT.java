package interfaces;

public interface StackADT<T> {
	public void push(T element);
	public T pop() throws Exception;
	
	public T peek() throws Exception;
	
	public int size();
	
	public boolean isEmpty();
	
	public String toString();
}
