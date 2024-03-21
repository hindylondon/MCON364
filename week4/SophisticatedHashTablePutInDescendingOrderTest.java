package week3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

class SophisticatedHashTablePutInDescendingOrderTest {
	SophisticatedHashTable sht = new SophisticatedHashTable(50);

	//test that it returns not null
	@Test
	void testThatItReturnsNonNullArrayList() {
		sht.insert("apple");
		sht.insert("banana");
		sht.insert("apple");
		sht.insert("orange");

		assertNotNull(sht.putInDescendingOrder());
	}
	
	//returns right size of arraylist
	void testThatItReturnsTheRightSizeArrayList() {
		sht.insert("apple");
		sht.insert("banana");
		sht.insert("apple");
		sht.insert("orange");
		
		sht.putInDescendingOrder();

		assertEquals(sht.getSize(), 4);
	}
	
	//same entries as original hash
	void testThatItHasTheSameEntriesAsHash() {
		sht.insert("apple");
		sht.insert("banana");
		sht.insert("apple");
		sht.insert("orange");
		
		int index = 0;
		
		String[] original = new String[4];
		Iterator<LinkedHashEntry> iterator = sht.iterator();
		while(iterator.hasNext()) {
			LinkedHashEntry e = iterator.next();
			original[index++] = e.key;
		}
		
		String[] sorted = new String[4];
		
		sht.putInDescendingOrder();
		
		while(iterator.hasNext()) {
			LinkedHashEntry e = iterator.next();
			sorted[index++] = e.key;
		}
		
		assertArrayEquals(original, sorted);
	}
	
	//it sorts properly
	void testThatItIsSortedProperly() {
		sht.insert("apple");
		sht.insert("banana");
		sht.insert("apple");
		sht.insert("orange");
		
		ArrayList<LinkedHashEntry> entries = sht.putInDescendingOrder();
		
		for (int i = 0; i < sht.getSize(); i++) {
			assertTrue(entries.get(i).value >= entries.get(i + 1).value);
		}
	}
	
	//properly handles collisions
	void testThatItHandlesCollisions() {
		sht.insert("apple");
		sht.insert("banana");
		sht.insert("apple");
		sht.insert("orange");
		
		sht.insert("pear");
		
		ArrayList<LinkedHashEntry> entries = sht.putInDescendingOrder();
		
		int prev = Integer.MAX_VALUE;
		
		for (LinkedHashEntry entry : entries) {
			if (entry.key.equals("pear")) {
				assertTrue(entry.value <= prev);
			}
			prev = entry.value;
		}
	}
	
	//returns empty when empty
	void testThatItReturnsEmptyWhenEmpty() {
		sht.putInDescendingOrder();
		
		assertEquals(sht.getSize(), 0);
	}

}
