package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SophisticatedHashTable implements HashTableInterface {
	private static int TABLE_SIZE;
	private int size;
	private LinkedHashEntry[] table;

	// constructor
	public SophisticatedHashTable(int ts) {
		this.size = 0;
		this.TABLE_SIZE = ts;
		this.table = new LinkedHashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}
	}

	public int getSize() {
		return size;
	}

	public void makeEmpty() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}
	}

	public int get(String key) {
		int hash = (sophisticatedHash(key) % TABLE_SIZE);

		if (table[hash] == null) {
			return -1;
		} else {
			LinkedHashEntry entry = table[hash];

			while (entry != null && !entry.key.equals(key)) {
				entry = entry.next;
			}

			if (entry == null) {
				return -1;
			} else {
				return entry.value;
			}
		}
	}

	public void insert(String key) {
		int hash = (sophisticatedHash(key) % TABLE_SIZE);

		// If the slot is empty, create a new entry
		if (table[hash] == null) {
			table[hash] = new LinkedHashEntry(key, 1);
			System.out.println("Inserted Key: " + key + ", Value: 1 into slot " + hash);
		} else {
			// Check if the key already exists in the chain
			LinkedHashEntry entry = table[hash];
			LinkedHashEntry prevEntry = null;
			while (entry != null && !entry.key.equals(key)) {
				prevEntry = entry;
				entry = entry.next;
			}

			// If the key already exists, update the value
			if (entry != null && entry.key.equals(key)) {
				entry.value++;
				System.out.println("Updated value for Key: " + key + " to: " + entry.value);
			} else {
				// Otherwise, add the new entry to the end of the chain
				prevEntry.next = new LinkedHashEntry(key, 1);
				System.out.println("Inserted Key: " + key + ", Value: 1 into slot " + hash);
			}
		}
		size++; // Increment size after adding a new entry
	}

	private int sophisticatedHash(String key) {
		int prime = 17;
		int hashValue = 0;

		// First hash function
		for (int i = 0; i < key.length(); i++) {
			hashValue += (int) key.charAt(i);
		}

		// Second hash function (double hashing)
		int hash2 = prime - (hashValue % prime);

		// Calculate the combined hash value
		return (hashValue + hash2) % TABLE_SIZE;
	}

	public void remove(String key) {
		int hash = (sophisticatedHash(key) % TABLE_SIZE);

		if (table[hash] != null) {
			LinkedHashEntry prevEntry = null;
			LinkedHashEntry entry = table[hash];

			while (entry != null && !entry.key.equals(key)) {
				prevEntry = entry;
				entry = entry.next;
			}

			if (entry.key.equals(key)) {
				if (prevEntry == null) {
					table[hash] = entry.next;
				} else {
					prevEntry.next = entry.next;
				}
				entry = entry.next;
			}
		}
		size--;

	}

	public void printHashTable() {
		for (int i = 0; i < TABLE_SIZE; i++) {
			System.out.println("\nBucket " + (i + 1) + ": ");

			LinkedHashEntry entry = table[i];
			while (entry != null) {
				System.out.println(entry.toString() + " ");
				entry = entry.next;
			}
		}
		System.out.println();

	}

	@Override
	public int getTableSize() {
		return TABLE_SIZE;
	}

	public Iterator<LinkedHashEntry> iterator() {
		return new WordIterator();
	}

	private class WordIterator implements Iterator<LinkedHashEntry> {
		private int currentBucket = 0;
		private LinkedHashEntry currentEntry = null;

		@Override
		public boolean hasNext() {
			// Check if there are more elements in the current bucket
			if (currentEntry != null && currentEntry.next != null) {
				return true;
			}
			// check if there are more buckets with entries
			for (int i = currentBucket + 1; i < TABLE_SIZE; i++) {
				if (table[i] != null) {
					return true;
				}
			}
			return false;
		}

		@Override
		public LinkedHashEntry next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			// if current entry is null or no next entry
			if (currentEntry == null || currentEntry.next == null) {
				// move to next filled bucket
				while (table[currentBucket] == null && currentBucket < TABLE_SIZE) {
					currentBucket++;
				}
				// update current entry to the next filled bucket
				if (currentBucket >= TABLE_SIZE) {
					return null;
				}
				currentEntry = table[currentBucket];
			} else {
				// move to next entry in this bucket
				currentEntry = currentEntry.next;
			}

			return currentEntry;
		}
	}

	// get count of word in story
	public int getWordCount(String word) {
		int hash = (sophisticatedHash(word) % TABLE_SIZE);

		if (table[hash] == null) {
			// word is not in hash table
			return 0;
		} else {
			int count = 0;
			LinkedHashEntry entry = table[hash];

			while (entry != null) {
				// if word is found
				if (entry.key.equals(word)) {
					// add more to count
					count += entry.value;
				}
				// move on to next entry
				entry = entry.next;
			}
			return count;
		}
	}

	@Override
	public int getLinkedListLength(String word) {
		// get the length of the linked list
		int hash = (sophisticatedHash(word) % TABLE_SIZE);

		if (table[hash] == null) {
			return 0;
		} else {
			int length = 0;
			LinkedHashEntry entry = table[hash];

			while (entry != null) {
				if (entry.key.equals(word)) {
					length++;
				}
				entry = entry.next;
			}
			return length;
		}

	}
	
	private static class EntryComparator implements Comparator<LinkedHashEntry>{
		public int compare(LinkedHashEntry e1, LinkedHashEntry e2) {
			return Integer.compare(e2.value, e1.value);
		}
	}

	// put the words in descending order by count
    public ArrayList<LinkedHashEntry> putInDescendingOrder() {
        ArrayList<LinkedHashEntry> entries = new ArrayList<>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                entries.add(entry);
                entry = entry.next;
            }
        }

        // Sort the entries based on their values (word counts) using the custom comparator
        Collections.sort(entries, new EntryComparator());
        return entries;
    }
    
    public int printUnusedSlots() {
    	int unused = 0;
    	for (int i = 0; i < TABLE_SIZE; i++) {
    		if (table[i] == null) {
    			unused++;
    		}
    	}
    	return unused;
    }

}
