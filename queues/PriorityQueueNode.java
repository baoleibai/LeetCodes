package queues;

public class PriorityQueueNode<T> implements Comparable<PriorityQueueNode> {

	private static int nextOrder = 0;
	private int priority;
	private int order;
	private T element;

	public PriorityQueueNode(T obj, int priority) {
		// TODO Auto-generated constructor stub
		element = obj;
		this.priority = priority;
		order = nextOrder;
		nextOrder++;
	}

	public T getElement() {
		return element;
	}

	public int getPriority() {
		return priority;
	}

	public int getOrder() {
		return order;
	}

	public String toString() {
		return (element.toString() + priority + order);
	}

	@Override
	public int compareTo(PriorityQueueNode obj) {
		// TODO Auto-generated method stub
		PriorityQueueNode<T> temp = obj;
		if (priority > temp.getPriority()) {
			return 1;
		} else if (priority < temp.getPriority()) {
			return -1;
		} else {
			if (order > temp.getOrder()) {
				return 1;
			} else if (order < temp.getOrder()){
				return -1;
			} else {
				return 0;
			}
		}
	}
}
