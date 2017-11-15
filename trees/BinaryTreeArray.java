package trees;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

import interfaces.BinaryTreeADT;
import lists.ArrayUnorderedList;

public class BinaryTreeArray<T> implements BinaryTreeADT<T> {

	public int count;
	public static final int capacity = 50;
	public T[] tree;

	public BinaryTreeArray() {
		tree = (T[]) (new Object[capacity]);
		count = 0;
	}

	public BinaryTreeArray(T element) {
		tree = (T[]) (new Object[capacity]);
		count = 1;
		tree[0] = element;
	}

	protected void expandCapacity() {
		T[] temp = Arrays.copyOf(tree, tree.length * 2);
		tree = temp;
	}

	@Override
	public T getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		if (find(element) != null) {
			return true;
		}
		return false;
	}

	@Override
	public T find(T targetElement) {
		T temp = null;
		boolean found = false;
		for (int ct = 0; ct < count && !found; ct++)
			if (targetElement.equals(tree[ct])) {
				found = true;
				temp = tree[ct];
			}
		return temp;
	}

	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		ArrayUnorderedList<T> arrayUnorderedList = new ArrayUnorderedList<>();
		iteratorInOrderInternal(0, arrayUnorderedList);
		
		return arrayUnorderedList.iterator();
	}
	
	private void iteratorInOrderInternal(int node, ArrayUnorderedList<T> data) {
		if (node < tree.length && tree[node] != null) {
			int leftNode = 2 * node + 1;
			iteratorInOrderInternal(leftNode, data);
			try {
				data.addToEnd(tree[node]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int rightNode = 2 * (node + 1);
			iteratorInOrderInternal(rightNode, data);
		}
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
