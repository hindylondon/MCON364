package week2;

import java.util.*;

public class BST<T extends Comparable<T>> implements BSTInterface<T> {
	// fields
	protected BSTNode<T> root;
	protected Comparator<T> comp;
	protected boolean found;

	public BST() {
		// general constructor
		root = null;
		comp = new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				return ((Comparable<T>) o1).compareTo(o2);
			}

		};
	}

	public BST(Comparator<T> comp) {
		// comparator constructor, should the user want to implement their own
		root = null;
		this.comp = comp;
	}

	@Override
	public boolean add(T element) {
		// add method to BST, retaining BST properties
		root = recAdd(element, root);
		System.out.println("Adding " + element + " to the Binary Search Tree...");
		return true;
	}

	private BSTNode<T> recAdd(T element, BSTNode<T> node) {
		// add method to BST, retaining BST properties through recursion
		if (node == null) {
			node = new BSTNode<T>(element);
		} else if (comp.compare(element, node.getInfo()) <= 0) {
			System.out.println("This node is less then the current node. It will go left...");
			node.setLeft(recAdd(element, node.getLeft()));
		} else {
			System.out.println("This node is more then the current node. It will go right...");
			node.setRight(recAdd(element, node.getRight()));
		}
		return node;
	}

	@Override
	public T get(T target) {
		// returns info of whats at the target location
		// if doesn't exist, returns null
		return recGet(target, root);
	}

	private T recGet(T target, BSTNode<T> node) {
		// recursively goes thru BST until
		// returns info of whats at the target location
		if (node == null) {
			System.out.println("This target does not exist in this Binary Search Tree.");
			return null;
		} else if (comp.compare(target, node.getInfo()) < 0) {
			System.out.println("This node is less then the current node. We will go left to find it...");
			return recGet(target, node.getLeft());
		} else if (comp.compare(target, node.getInfo()) > 0) {
			System.out.println("This node is more then the current node. We will go right to find it...");
			return recGet(target, node.getRight());
		} else {
			System.out.println("The element you got is: " + node.getInfo());
			return node.getInfo();
		}
	}

	@Override
	public boolean contains(T target) {
		// returns true if BST contains the target node
		return recContains(target, root);
	}

	private boolean recContains(T target, BSTNode<T> node) {
		// recursively goes thru BST and
		// returns true if BST subtree contains the target node
		if (node == null) {
			System.out.println("This Binary Search Tree does not contain: " + target);
			return false;
		} else if (comp.compare(target, node.getInfo()) < 0) {
			return recContains(target, node.getLeft());
		} else if (comp.compare(target, node.getInfo()) > 0) {
			return recContains(target, node.getRight());
		} else {
			System.out.println("This Binary Search Tree contains: " + target);
			return true;
		}
	}

	@Override
	public boolean remove(T target) {
		// removes a node and returns true, if doesnt exist, returns false
		root = recRemove(target, root);
		if (found) {
			System.out.println("You have removed: " + target);
		} else {
			System.out.println("This Binary Search Tree does not have this node.");
		}
		return found;
	}

	private BSTNode<T> recRemove(T target, BSTNode<T> node) {
		// removes a node and returns true,
		// if doesnt exist, returns false, through recursion
		if (node == null) {
			found = false;
		} else if (comp.compare(target, node.getInfo()) < 0) {
			node.setLeft(recRemove(target, node.getLeft()));
		} else if (comp.compare(target, node.getInfo()) > 0) {
			node.setRight(recRemove(target, node.getRight()));
		} else {
			node = removeNode(node);
			found = true;
		}
		return node;
	}

	private BSTNode<T> removeNode(BSTNode<T> node) {
		// removes the info at this node
		T data;
		if (node.getLeft() == null) {
			return node.getRight();
		} else if (node.getRight() == null) {
			return node.getLeft();
		} else {
			data = getPredecessor(node.getLeft());
			node.setInfo(data);
			node.setLeft(recRemove(data, node.getLeft()));
			return node;
		}
	}

	private T getPredecessor(BSTNode<T> subtree) {
		// returns what was before this node
		BSTNode<T> temp = subtree;
		while (temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp.getInfo();
	}

	@Override
	public boolean isFull() {
		// its never full because its based on links
		System.out.println("This Binary Search Tree is not full.");
		return false;
	}

	@Override
	public boolean isEmpty() {
		// only if the root is null does it return empty
		if (root == null) {
			System.out.println("This Binary Search Tree is empty.");
		}
		return (root == null);
	}

	@Override
	public int size() {
		int size = recSize(root);
		System.out.println("The size of the binary search tree is: " + size);
		return size;
	}

	public int recSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + recSize(node.getLeft()) + recSize(node.getRight());
		}
	}

	@Override
	public T min() {
		// return null if BST is empty,
		// otherwise return the smallest element
		if (isEmpty()) {
			System.out.println("This Binary Search Tree is empty.");
			return null;
		} else {
			BSTNode<T> node = root;
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
			System.out.println("The minimum in this Binary Search Tree is: " + node.getInfo());
			return node.getInfo();
		}

	}

	@Override
	public T max() {
		// returns max in the BST, if empty, returns null
		if (isEmpty()) {
			System.out.println("This Binary Search Tree is empty.");
			return null;
		} else {
			BSTNode<T> node = root;
			while (node.getRight() != null) {
				node = node.getRight();
			}
			System.out.println("The maximum in this Binary Search Tree is: " + node.getInfo());
			return node.getInfo();
		}
	}

	@Override
	public Iterator<T> getIterator(BSTInterface.Traversal orderType) {
		// takes the specified ordering traversal and calls the corresponding
		// method to traverse
		final Queue<T> infoQueue = new Queue<T>();
		if (orderType == BSTInterface.Traversal.Preorder) {
			preOrder(root, infoQueue);
		} else if (orderType == BSTInterface.Traversal.Inorder) {
			inOrder(root, infoQueue);
		} else if (orderType == BSTInterface.Traversal.Postorder) {
			postOrder(root, infoQueue);
		} else if (orderType == BSTInterface.Traversal.BreadthFirst) {
			breadthFirst(root);
		}
		// returns a new Iterator
		return new Iterator<T>() {
			public boolean hasNext() {
				// if there is more in the queue, returns true
				return !infoQueue.isEmpty();
			}

			public T next() {
				// dequeues what is next in the queue
				if (!hasNext()) {
					throw new IndexOutOfBoundsException(
							"Illegal invocation of next" + " in BinarySearchTree iterator.\n");
				}
				return infoQueue.dequeue();
			}

			public void remove() {
				// cant remove, throws exception
				throw new UnsupportedOperationException(
						"Unsupported remove attempted" + " on BinarySearchTree iterator.\n");
			}
		};
	}

	private void preOrder(BSTNode<T> node, Queue<T> q) {
		System.out.println("Recursively going through PreOrder Traversal...");
		// depth-first traversal
		// checks current node, recursively traverses left, recursively traverses right
		if (node != null) {
			System.out.println("Visiting the current node: " + node.getInfo());
			q.enqueue(node.getInfo());
			if (node.getLeft() != null) {
				System.out.println("Visiting the left subtree: " + node.getLeft().getInfo());
			} else {
				System.out.println("Visting the left subtree: null");
			}
			preOrder(node.getLeft(), q);
			if (node.getRight() != null) {
				System.out.println("Visiting the right subtree: " + node.getRight().getInfo());
			} else {
				System.out.println("Visiting the right subtree: null");
			}
			preOrder(node.getRight(), q);
		}
	}

	private void inOrder(BSTNode<T> node, Queue<T> q) {
		// depth first traversal
		// recursively traverses left, checks current node, recursively traverses right
		System.out.println("Recursively going through InOrder Traversal...");
		if (node != null) {
			if (node.getLeft() != null) {
				System.out.println("Visiting the left subtree: " + node.getLeft().getInfo());
			} else {
				System.out.println("Visting the left subtree: null");
			}
			inOrder(node.getLeft(), q);
			System.out.println("Visiting the current node: " + node.getInfo());
			q.enqueue(node.getInfo());
			if (node.getRight() != null) {
				System.out.println("Visiting the right subtree: " + node.getRight().getInfo());
			} else {
				System.out.println("Visiting the right subtree: null");
			}
			inOrder(node.getRight(), q);
		}
	}

	private void postOrder(BSTNode<T> node, Queue<T> q) {
		// depth first traversal
		// recursively traverses left, recursively traverses right, checks current node
		System.out.println("Recursively going through PostOrder Traversal...");
		if (node == null) {
			return;
		}
		if (node.getLeft() != null) {
			System.out.println("Visiting the left subtree: " + node.getLeft().getInfo());
		} else {
			System.out.println("Visting the left subtree: null");
		}
		postOrder(node.getLeft(), q);
		if (node.getRight() != null) {
			System.out.println("Visiting the right subtree: " + node.getRight().getInfo());
		} else {
			System.out.println("Visiting the right subtree: null");
		}
		postOrder(node.getRight(), q);
		System.out.println("Visiting the current node: " + node.getInfo());
		q.enqueue(node.getInfo());
	}

	private void breadthFirst(BSTNode<T> originalNode) {
	    System.out.println("Breadth First Traversal...");
	    java.util.Queue<BSTNode<T>> breadthQueue = new LinkedList<>();
	    if (originalNode != null) {
	        breadthQueue.add(originalNode);
	        while (!breadthQueue.isEmpty()) {
	            BSTNode<T> node = breadthQueue.poll();
	            System.out.println("Visiting the current node: " + node.getInfo());

	            if (node.getLeft() != null) {
	                System.out.println("Visiting the node to the left of current node: " + node.getLeft().getInfo());
	                breadthQueue.add(node.getLeft());
	            }
	            if (node.getRight() != null) {
	                System.out.println("Visiting the node to the right of current node: " + node.getRight().getInfo());
	                breadthQueue.add(node.getRight());
	            }
	        }
	    }
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Size: ").append(size()).append("\n");
		sb.append("Min: ").append(min()).append("\n");
		sb.append("Max: ").append(max()).append("\n");
		sb.append("Elements: ");

		return toStringElements(root, sb);
	}

	private String toStringElements(BSTNode<T> node, StringBuilder sb) {
		if (node != null) {
			toStringElements(node.getLeft(), sb);

			sb.append(node.getInfo()).append(" ");

			toStringElements(node.getRight(), sb);

		}
		return sb.toString();
	}

}