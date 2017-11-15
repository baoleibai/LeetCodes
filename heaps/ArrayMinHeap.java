package heaps;

import interfaces.HeapADT;
import trees.BinaryTreeArray;

public class ArrayMinHeap<T> extends BinaryTreeArray<T> implements HeapADT<T> {

	/**
	 * The addElement method for the array implementation must accomplish three
	 * tasks: 1, add the new node at the appropriate location, 2, reorder the
	 * heap to maintain the ordering property, 3, and increment the count by
	 * one.
	 */
	@Override
	public void addElement(T element) {
		// TODO Auto-generated method stub
		if (count == tree.length) {
			expandCapacity();
		}
		tree[count] = element;
		count++;
		if (count > 1) {
			heapifyAdd();
		}
	}

	/**
	 * Reorders this heap to maintain the ordering property after adding a node.
	 */
	private void heapifyAdd() {
		T temp;
		int next = count - 1;
		temp = tree[next];
		// For any node n other than the root, n’s parent is in position (n –
		// 1)/2.
		while ((next != 0) && (((Comparable) temp).compareTo(tree[(next - 1) / 2]) < 0)) {
			tree[next] = tree[(next - 1) / 2];
			next = (next - 1) / 2;
		}
		tree[next] = temp;
	}

	/**
	 * The removeMin method must accomplish three tasks: 1, replace the element
	 * stored in the root with the element stored in the last element, 2,
	 * reorder the heap if necessary, 3, and return the original root element.
	 */
	@Override
	public T removeMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Heap");
		}
		T minElement = tree[0];
		// 1, replace the element stored in the root with the element stored in
		// the last element
		tree[0] = tree[count - 1];
		// reorder the heap if necessary
		heapifyRemove();
		// return the original root element
		count--;
		return minElement;
	}

	/**
	 * Reorders this heap to maintain the ordering property.
	 */
	private void heapifyRemove() {
		T temp;
		int node = 0;
		int left = 1;
		int right = 2;
		int next;

		if ((tree[left] == null) && (tree[right] == null))
			next = count;
		else if (tree[left] == null)
			next = right;
		else if (tree[right] == null)
			next = left;
		else if (((Comparable) tree[left]).compareTo(tree[right]) < 0)
			next = left;
		else
			next = right;
		
		// remember the root node.
		temp = tree[node];
		
		// if next is not null AND next is less than root node temp.
		while ((next < count) && (((Comparable) tree[next]).compareTo(temp) < 0)) {
			tree[node] = tree[next];
			node = next;
			left = 2 * node + 1;
			right = 2 * (node + 1);
			if ((tree[left] == null) && (tree[right] == null))
				next = count;
			else if (tree[left] == null)
				next = right;
			else if (tree[right] == null)
				next = left;
			else if (((Comparable) tree[left]).compareTo(tree[right]) < 0)
				next = left;
			else
				next = right;
		}
		tree[node] = temp;
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}
}
