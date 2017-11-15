package interfaces;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
	/**
	 * Returns a reference to the root element
	 *
	 * @return a reference to the root
	 */
	public T getRoot();

	public boolean isEmpty();

	/**
	 * Returns the number of elements in this binary tree.
	 *
	 * @return the integer number of elements in this tree
	 */
	public int getSize();

	/**
	 * Returns true if the binary tree contains an element that matches the
	 * specified element and false otherwise.
	 *
	 * @param targetElement
	 *            the element being sought in the tree
	 * @return true if the tree contains the target element
	 */
	public boolean contains(T element);

	/**
	 * Returns a reference to the specified element if it is found in this
	 * binary tree. Throws an exception if the specified element is not found.
	 *
	 * @param targetElement
	 *            the element being sought in the tree
	 * @return a reference to the specified element
	 */
	public T find(T element);

	public String toString();

	/**
	 * which is accomplished by visiting the left child of the node, then the
	 * node, then any remaining nodes, starting with the root
	 * 
	 * Performs an inorder traversal on this binary tree by calling an
	 * overloaded, recursive inorder method that starts with the root.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorInOrder();

	/**
	 * which is accomplished by visiting each node, followed by its children,
	 * starting with the root
	 * 
	 * Performs a preorder traversal on this binary tree by calling an
	 * overloaded, recursive preorder method that starts with the root.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorPreOrder();

	/**
	 * which is accomplished by visiting the children, then the node, starting
	 * with the root
	 * 
	 * Performs a postorder traversal on this binary tree by calling an
	 * overloaded, recursive postorder method that starts with the root.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorPostOrder();

	/**
	 * Performs a level-order traversal on the binary tree, using a queue.
	 *
	 * @return an iterator over the elements of this binary tree
	 */
	public Iterator<T> iteratorLevelOrder();
}
