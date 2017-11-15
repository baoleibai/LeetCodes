package interfaces;

public interface QueueADT<T> {

	public void enqueue(T element);
	public T dequeue() throws Exception;
	public T front() throws Exception;
	public int size();
	public boolean isEmpty();
	public String toString();
}
