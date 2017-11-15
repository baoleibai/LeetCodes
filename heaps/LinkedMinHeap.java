package heaps;

import java.util.Iterator;

import interfaces.HeapADT;
import trees.LinkedBinaryTree;

public class LinkedMinHeap<T> extends LinkedBinaryTree<T> implements HeapADT<T> {

	private HeapNode<T> lastNode = null;

	/**
	 * Adds the specified element to this heap in the appropriate position
	 * according to its key value. Note that equal elements are added to the
	 * right.
	 *
	 * Because a heap is a complete tree, there is only one correct location for
	 * the insertion of a new node, and that is either the next open position
	 * from the left at level h or the first position on the left at level h + 1
	 * if level h is full.
	 * 
	 * Once we have located the new node in the proper position, we then must
	 * account for the ordering property. To do this, we simply compare the new
	 * value to its parent value and swap the values if the new node is less
	 * than its parent. We continue this process up the tree until the new value
	 * either is greater than its parent or is in the root of the heap.
	 * 
	 * @param element
	 *            the element to be added to this heap
	 */
	@Override
	public void addElement(T element) {
		HeapNode<T> temp = new HeapNode<T>(element);
		if (root == null) {
			root = temp;
		} else {
			HeapNode<T> next_parent = getNextParentAdd();
			if (next_parent.leftChild == null) {
				next_parent.leftChild = temp;
			} else {
				next_parent.rightChild = temp;
			}

			temp.parent = next_parent;
		}
		lastNode = temp;
		count++;
		if (count > 1) {
			reOrderHeapAfterAdd();
		}
	}

	/**
	 * Note that the reOrderHeap() method does not perform a full swap of parent
	 * and child as it moves up the heap. Instead, it simply shifts parent
	 * elements down until a proper insertion point is found and then assigns
	 * the new value into that location. This does not actually improve the O()
	 * of the algorithm as it would be O(log n) even if we were performing full
	 * swaps. However, it does improve the efficiency since it reduces the
	 * number of assignments performed at each level of the heap
	 */
	private void reOrderHeapAfterAdd() {
		HeapNode<T> next = lastNode;
		T temp = next.element;

		// next is not root and next's element's priority and order is larger
		// than its parent.
		while ((next != root) && ((Comparable<T>) temp).compareTo(next.parent.element) < 0) {
			// shift parent's element down to its child and replace child's
			// element.
			next.element = next.parent.element;
			next = next.parent;
		}
		next.element = temp;
	}

	/**
	 * Returns the node that will be the parent of the new node
	 *
	 * @return the node that will be a parent of the new node
	 */
	private HeapNode<T> getNextParentAdd() {
		HeapNode<T> result = lastNode;

		// traverse up the tree. If the lastNode is the leftChild of parent,
		// then we will find a position on the right of the tree.
		while ((result != root) && (result.parent.leftChild != result)) {
			result = result.parent;
		}

		if (result != root) {
			if (result.parent.rightChild == null) {
				result = result.parent;
			} else {
				result = (HeapNode<T>) result.parent.rightChild;
				while (result.leftChild != null) {
					return (HeapNode<T>) result.leftChild;
				}
			}
		} else {
			// The last node is on the last node on the level H.
			// Therefor, find a empty position on the leftest node of root.
			while (result.leftChild != null) {
				result = (HeapNode<T>) result.leftChild;
			}
		}
		return result;
	}

	/**
	 * The removeMin method must accomplish three tasks: 1, replace the element
	 * stored in the root with the element stored in the last node, 2, reorder
	 * the heap if necessary 3, and return the original root element.
	 * 
	 * Remove the element with the lowest value in this heap and returns a
	 * reference to it. Throws an EmptyCollectionException if the heap is empty.
	 *
	 * @return the element with the lowest value in this heap
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	@Override
	public T removeMin() throws Exception {
		if (isEmpty()) {
			throw new Exception("Empty Heap");
		}

		T minElement = root.element;
		if (count == 1) {
			root = null;
			lastNode = null;
		} else {
			HeapNode<T> next_last = getNewLastNode();
			// Reset the last node to null because we are going to
			// move the element of last node to root.
			if (lastNode.parent.leftChild == lastNode) {
				lastNode.parent.leftChild = null;
			} else {
				lastNode.parent.rightChild = null;
			}
			root.element = lastNode.element;
			lastNode = next_last;
			reOrderAfterRemove();
		}

		count--;
		return minElement;
	}

	/**
	 * the new root node must be smaller than its left and right child.
	 * if both of left and right child exists, compare root with smaller child.
	 */
	private void reOrderAfterRemove() {
		T temp;
		HeapNode<T> node = (HeapNode<T>) root;
		HeapNode<T> left = (HeapNode<T>) node.leftChild;
		HeapNode<T> right = (HeapNode<T>) node.rightChild;
		HeapNode<T> next = reOrderAfterFindNext(node);

		temp = node.element;
		while ((next != null) && (((Comparable) next.element).compareTo(temp) < 0)) {
			//move child element up a level.
			node.element = next.element;
			//point current node;
			node = next;
			next = reOrderAfterFindNext(node);
		}
		node.element = temp;
	}
	
	private HeapNode<T> reOrderAfterFindNext(HeapNode<T> next) {
		HeapNode<T> left = (HeapNode<T>) next.leftChild;
		HeapNode<T> right = (HeapNode<T>) next.rightChild;

		if ((left == null) && (right == null)) {
			next = null;
		} else if (left == null) {
			next = right;
		} else if (right == null) {
			next = left;
		} else {
			if (((Comparable) left.element).compareTo(right.element) < 0) {
				next = left;
			} else {
				next = right;
			}
		}
		return next;
	}

	/**
	 * Returns the node that will be the new last node after a remove.
	 *
	 * @return the node that will be the new last node after a remove
	 */
	private HeapNode<T> getNewLastNode() {
		HeapNode<T> result = lastNode;
		// if the current last node is the left child of its parent.
		// traverse up to find a parent which is not the left child.
		while ((result != root) && (result.parent.leftChild == result)) {
			result = result.parent;
		}

		if (result != root) {
			result = (HeapNode<T>) result.parent.leftChild;
		}
		while (result.rightChild != null) {
			result = (HeapNode<T>) result.rightChild;
		}

		return result;
	}

	@Override
	public T findMin() {
		// TODO Auto-generated method stub
		return null;
	}
}
