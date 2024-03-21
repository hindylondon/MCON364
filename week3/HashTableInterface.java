package week3;

import java.util.ArrayList;
import java.util.Iterator;

public interface HashTableInterface<K, V> extends Iterable<LinkedHashEntry> {
	int getTableSize();
	int getSize();
	void makeEmpty();
	int get(String key);
	void insert(String key);
	void remove(String key);
	void printHashTable();
	Iterator<LinkedHashEntry> iterator();
	int getWordCount(String word);
	int getLinkedListLength(String word);
	ArrayList<LinkedHashEntry> putInDescendingOrder();
	int printUnusedSlots();
	
}
