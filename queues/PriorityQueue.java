package queues;

public class PriorityQueue<T> implements ArrayHeap<PriorityQueueNode<T>> {
	/**
	 * Creates an empty priority queue.
	 */
	public PriorityQueue() {
		super();
	}

	/**
	 *
	 * Adds the given element to this PriorityQueue.
	 *
	 * @param object
	 *            the element to be added to the priority queue
	 * @param priority
	 *            the integer priority of the element to be added
	 */
	public void addElement(T object, int priority) {
		PriorityQueueNode<T> node = new PriorityQueueNode<T>(object, priority);
		super.addElement(node);
	}

	/**
	 * The removeMin method removes the minimum element from the minheap and
	 * returns it. Because the minimum element is stored in the root of a
	 * minheap, we need to return the element stored at the root and replace it
	 * with another element in the heap. As with the addElement operation, to
	 * maintain the completeness of the tree, there is only one valid element to
	 * replace the root, and that is the element stored in the last leaf in the
	 * tree. This last leaf will be the rightmost leaf at level h of the tree.
	 * 
	 * Once the element stored in the last leaf has been moved to the root, the
	 * heap will then have to be reordered to maintain the heap’s ordering
	 * property. This is accomplished by comparing the new root element to the
	 * smaller of its children and then swapping them if the child is smaller.
	 * This process is repeated on down the tree until the element either is in
	 * a leaf or is less than both of its children. Removes the next highest
	 * priority element from this priority queue and returns a reference to it.
	 *
	 * @return a reference to the next highest priority element in this queue
	 */
	public T removeNext() {
		PriorityQueueNode<T> temp = (PriorityQueueNode<T>) super.removeMin();
		return temp.getElement();
	}

}
