package trees;

public class BinaryTreeNode<T> {
	public T element;
	public BinaryTreeNode<T> leftChild;
	public BinaryTreeNode<T> rightChild;
	
	public BinaryTreeNode(T element) {
		// TODO Auto-generated constructor stub
		this.element = element;
		leftChild = rightChild = null;
	}
	
	public int numChildren() {
		int count = 0;
		if (leftChild != null) {
			count = 1 + leftChild.numChildren();
		}
		
		if (rightChild != null) {
			count = count + 1 + rightChild.numChildren();
		}
		return count;
	}
}
