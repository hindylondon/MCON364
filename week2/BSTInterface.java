package week2;

import java.util.*;

public interface BSTInterface<T> extends CollectionInterface<T>, Iterable<T> {
	public enum Traversal {Inorder, Preorder, Postorder, BreadthFirst};
	
	T min();
	
	T max();
	
	public Iterator<T> getIterator(Traversal orderType);

}
