package trees;

import java.util.Iterator;

import interfaces.BinarySearchTreeADT;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

	public LinkedBinarySearchTree() {
		// TODO Auto-generated constructor stub
		super();
	}

	public LinkedBinarySearchTree(T element) {
		super(element);
	}

	@Override
	public void addElement(T element) throws Exception {
		// TODO Auto-generated method stub

		if (element == null) {
			throw new Exception("element is null.");
		}

		addElementInternal(root, element);
	}

	private void addElementInternal(BinaryTreeNode<T> target, T element) {
		BinaryTreeNode<T> newElement = new BinaryTreeNode<T>(element);
		if (target == null) {
			target = newElement;
			count++;
		} else {
			Comparable<T> elementComparable = (Comparable<T>) element;
			if (elementComparable.compareTo(target.element) < 0) {
				addElementInternal(target.leftChild, element);
			} else {
				addElementInternal(target.rightChild, element);
			}
		}
	}

	@Override
	public T removeElement(T targetElement) throws Exception {
		// TODO Auto-generated method stub
		if (targetElement == null) {
			throw new Exception("element is null.");
		}
		return removeElementInternal(root, targetElement);
	}

	private T removeElementInternal(BinaryTreeNode<T> target, T element) {
		if (target != null) {
			Comparable<T> elementComparable = (Comparable<T>) element;
			if (elementComparable.compareTo(target.element) == 0) {
				T temp = target.element;
				target = shiftTree(target);
				count--;
				return temp;
			} else if (elementComparable.compareTo(target.element) < 0) {
				return removeElementInternal(target.leftChild, element);
			} else {
				return removeElementInternal(target.rightChild, element);
			}
		}

		return null;
	}

	/**
	 * shiftTree node:
	 * 
	 * ■ If the node has no children, replacement returns null.
	 * 
	 * ■ If the node has only one child, replacement returns that child.
	 * 
	 * ■ If the node to be removed has two children, replacement returns the
	 * inorder successor of the node to be removed (because equal elements are
	 * placed to the right).
	 * 
	 * Returns a reference to a node that will replace the one specified for
	 * removal. In the case where the removed node has two children, the inorder
	 * successor is used as its replacement.
	 *
	 * @param node
	 *            the node to be removed
	 * @return a reference to the replacing node
	 */
	private BinaryTreeNode<T> shiftTree(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> result = null;
		if ((node.leftChild == null) && (node.rightChild == null))
			result = null;
		else if ((node.leftChild != null) && (node.rightChild == null))
			result = node.leftChild;
		else if ((node.leftChild == null) && (node.rightChild != null))
			result = node.rightChild;
		else {
			BinaryTreeNode<T> parent = node;
			BinaryTreeNode<T> current = node.rightChild;

			while (current.leftChild != null) {
				parent = current;
				current = current.leftChild;
			}
			if (node.rightChild == current) {
				current.leftChild = node.leftChild;
			} else {
				parent.leftChild = current.rightChild;
				current.rightChild = node.rightChild;
				current.leftChild = node.leftChild;
			}
			result = current;
		}
		return result;
	}

	@Override
	public void removeAllOccurrences(T targetElement) {
		// TODO Auto-generated method stub
		while (contains(targetElement)) {
			try {
				removeElement(targetElement);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * There are three possible cases for the location of the minimum element in
	 * a binary search tree:
	 * 
	 * ■ If the root has no left child, then the root is the minimum element and
	 * the right child of the root becomes the new root.
	 * 
	 * ■ If the leftmost node of the tree is a leaf, then it is the minimum
	 * element and we simply set its parent’s left child reference to null.
	 * 
	 * ■ If the leftmost node of the tree is an internal node, then we set its
	 * parent’s left child reference to point to the right child of the node to
	 * be removed.
	 * 
	 * Removes the node with the least value from the binary search tree and
	 * returns a reference to its element. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 *
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	@Override
	public T removeMin() {
		// TODO Auto-generated method stub
		T temp = null;
		if (!isEmpty()) {
			if (root.leftChild == null) {
				temp = root.element;
				root = root.rightChild;
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = parent.leftChild;

				// find the min node(current) by find the leftmost node.
				while (current.leftChild != null) {
					parent = current;
					current = current.leftChild;
				}

				// Is current a leaf?
				temp = current.element;
				parent.leftChild = current.rightChild;

			}
			count--;
		}
		return temp;
	}

	@Override
	public T removeMax() {
		// TODO Auto-generated method stub
		T temp = null;
		if (!isEmpty()) {
			if (root.rightChild == null) {
				temp = root.element;
				root = root.leftChild;
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = parent.rightChild;

				while (current.rightChild != null) {
					parent = current;
					current = current.rightChild;
				}

				temp = current.element;
				parent.rightChild = current.leftChild;

			}
			count--;
		}
		return temp;
	}

	@Override
	public T findMin() {
		T temp = null;
		if (!isEmpty()) {
			
			if (root.leftChild == null && root.rightChild == null) {
				temp = root.element;
			} else if (root.leftChild == null && root.rightChild != null) {
				temp = root.element;
			} else if (root.leftChild != null && root.rightChild == null) {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.leftChild;

				while (current.leftChild != null) {
					parent = current;
					current = current.leftChild;
				}
				
				temp = current.element;
			}
		}
		return null;
	}

	@Override
	public T findMax() {
		T temp = null;
		if (!isEmpty()) {
			
			if (root.leftChild == null && root.rightChild == null) {
				temp = root.element;
			} else if (root.leftChild != null && root.rightChild == null) {
				temp = root.element;
			} else if (root.leftChild == null && root.rightChild != null) {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.rightChild;

				while (current.rightChild != null) {
					parent = current;
					current = current.rightChild;
				}
				
				temp = current.element;
			}
		}
		return null;
	}
}
