package hwn;

public class TreeNode<E> {

	private E data;
	private TreeNode<E> left, right;
	
	public TreeNode() {
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(E data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public E getData() {
		return data;
	}
	
	public TreeNode<E> getLeft() {
		return left;
	}
	
	public TreeNode<E> getRight() {
		return right;
	}
	
	public void setData(E data) {
		this.data = data;
	}
	
	public void setLeft(E left) {
		this.left = new TreeNode<E>(left);
	}
	
	public void setRight(E right) {
		this.right = new TreeNode<E>(right);
	}
}
