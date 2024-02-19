package week3;

public class BSTNode<T> {
	private T info;
	private BSTNode<T> left;
	private BSTNode<T> right;
	
	public BSTNode(T info) {
		this.info = info;
		this.left = null;
		this.right = null;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setLeft(BSTNode<T> link) {
		left = link;
	}
	
	public void setRight(BSTNode<T> link) {
		right = link;
	}
	
	public BSTNode<T> getLeft(){
		return left;
	}
	
	public BSTNode<T> getRight(){
		return right;
	}

}
