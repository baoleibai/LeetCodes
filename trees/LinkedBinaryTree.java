package trees;

import java.util.Iterator;

import interfaces.BinaryTreeADT;
import lists.ArrayUnorderedList;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

	protected int count;
	protected BinaryTreeNode<T> root;

	public LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
		root = null;
		count = 0;
	}

	public LinkedBinaryTree(T element) {
		root = new BinaryTreeNode<T>(element);
		count = 0;
	}

	@Override
	public T getRoot() {
		// TODO Auto-generated method stub
		return root.element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		if (this.find(element) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a reference to the specified target element if it is found in
	 * this binary tree. Throws a NoSuchElementException if the specified target
	 * element is not found in the binary tree.
	 *
	 * @param targetElement
	 *            the element being sought in this tree
	 * @return a reference to the specified target
	 * @throws ElementNotFoundException
	 *             if an element not found exception occurs
	 */
	@Override
	public T find(T element) {
		// TODO Auto-generated method stub
		BinaryTreeNode<T> target = findInternal(element, root);
		if (target == null) {
			return null;
		}
		return target.element;
	}

	/**
	 * Returns a reference to the specified target element if it is found in
	 * this binary tree.
	 * 
	 * @param targetElement
	 *            the element being sought in this tree
	 * @param next
	 *            the element to begin searching from
	 */
	private BinaryTreeNode<T> findInternal(T target, BinaryTreeNode<T> next) {
		if (next == null) {
			return null;
		}

		if (target.equals(next.element)) {
			return next;
		}

		BinaryTreeNode<T> temp = findInternal(target, next.leftChild);
		if (temp == null) {
			temp = findInternal(target, next.rightChild);
		}

		return temp;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		ArrayUnorderedList<T> arrayUnorderedList = new ArrayUnorderedList<>();

		iteratorInOrderInternal(root, arrayUnorderedList);

		return arrayUnorderedList.iterator();
	}

	private void iteratorInOrderInternal(BinaryTreeNode<T> rootNode, ArrayUnorderedList<T> arrayUnorderedList) {
		if (rootNode != null) {
			iteratorInOrderInternal(rootNode.leftChild, arrayUnorderedList);
			try {
				arrayUnorderedList.addToEnd(rootNode.element);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iteratorInOrderInternal(rootNode.rightChild, arrayUnorderedList);
		}
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		ArrayUnorderedList<T> arrayUnorderedList = new ArrayUnorderedList<>();

		iteratorPreOrderInternal(root, arrayUnorderedList);

		return arrayUnorderedList.iterator();
	}

	private void iteratorPreOrderInternal(BinaryTreeNode<T> rootNode, ArrayUnorderedList<T> arrayUnorderedList) {
		if (rootNode != null) {
			try {
				arrayUnorderedList.addToEnd(rootNode.element);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			iteratorPreOrderInternal(rootNode.leftChild, arrayUnorderedList);
			iteratorPreOrderInternal(rootNode.rightChild, arrayUnorderedList);
		}
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		ArrayUnorderedList<T> arrayUnorderedList = new ArrayUnorderedList<>();

		iteratorPreOrderInternal(root, arrayUnorderedList);

		return arrayUnorderedList.iterator();
	}

	private void iteratorPostOrderInternal(BinaryTreeNode<T> rootNode, ArrayUnorderedList<T> arrayUnorderedList) {
		if (rootNode != null) {
			iteratorPostOrderInternal(rootNode.leftChild, arrayUnorderedList);
			iteratorPostOrderInternal(rootNode.rightChild, arrayUnorderedList);
			try {
				arrayUnorderedList.addToEnd(rootNode.element);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}
}
