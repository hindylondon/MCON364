package week3;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
	public static <K> void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String filename = "src/week3/moppet.txt";

		// instantiate tablesize
		int tableSize = 50;

		BufferedReader reader = new BufferedReader(new FileReader(filename));
		ArrayList<String> wordsList = new ArrayList<>();
		
		HashTable hash = new HashTable(tableSize);

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				wordsList.addAll(Arrays.asList(words));

			}

			String again = "y";
			// allow the user to continuously search
			while (again.equals("y")) {
				String menuAgain = "y";
				
				
				
				Map<Integer, Function<K, Integer>> hashFunctions = new HashMap<>();
				hashFunctions.put(1, (Function<K, Integer>) hash.naiveHash);
				hashFunctions.put(2, (Function<K, Integer>) hash.sophisticatedHash);
				
				int hashFunctionName = chooseHash(sc); // get the name of the hash function to use
				
				Function<K, Integer> selectedHashFunction = hashFunctions.get(hashFunctionName);
				
				for (String word : wordsList) {
					word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
					int hashType = selectedHashFunction.apply((K) word);
					hash.insert(word);

				}
			}
		}

//				if (hashType == 1) {
//					NaiveHashTable naive = new NaiveHashTable(tableSize);
//
//					for (String word : wordsList) {
//						word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
//						naive.insert(word);
//
//					}
//					menu(sc, naive);
//					while (menuAgain.equals("y")) {
//						menuAgain = menu(sc, naive);
//					}
//
//					printReport(naive, tableSize);
//
//				} else {
//					SophisticatedHashTable sophist = new SophisticatedHashTable(tableSize);
//
//					for (String word : wordsList) {
//						word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
//
//						sophist.insert(word);
//
//					}
//
//					while (menuAgain.equals("y")) {
//						menuAgain = menu(sc, sophist);
//					}
//
//					printReport(sophist, tableSize);
//				}
//
//				again = goAgain(sc, "Hash");
//			}

	//	}

		catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
		reader.close();

		System.out.println("Thank you for using this hasher!");
		System.out.println("Goodbye");

	}
	


	// print out all the things that need reporting
	private static void printReport(HashTableInterface hash, int tableSize) {
		// words per book
		System.out.println("Number of Words In Book: " + hash.getSize());

		// print out of each slot
		hash.toString();

		// array size
		System.out.println("Array Size: " + tableSize);

		// number of unused slots
		System.out.println("Number of Unused Slots: " + hash.printUnusedSlots());

	}

	private static String goAgain(Scanner sc, String type) {
		// ask user if wants to go again
		System.out.println("Do you want to do another one? ");
		String input = sc.nextLine();

		// input validation for going again
		while (!input.toLowerCase().equals("y") && !input.toLowerCase().equals("n")) {
			System.out.println("Invalid Entry. Enter y or n. ");
			System.out.println("Do you want to do another " + type + "? ");
			input = sc.nextLine();
		}

		return input;
	}

	// menu for user to choose what to see
	private static String menu(Scanner sc, HashTableInterface hashType) {
		System.out.println();

		// display menu
		System.out.println("Please select an option from the menu: ");
		System.out.println("1) View the word count for a specific word, " + "as well as the length of it's linked list"
				+ "\n2) View the words in descending order by word count"
				+ "\n3) View a report on the internal structure of the hash table");

		// user choice
		int menuChoice = sc.nextInt();
		sc.nextLine();

		// input val
		while (menuChoice != 1 && menuChoice != 2 && menuChoice != 3) {
			System.out.println("Invalid Entry. Enter 1,2,or 3");
			System.out.println("Please select an option from the menu: ");
			System.out.println(
					"1) View the word count for a specific word, " + "as well as the length of it's linked list"
							+ "\n2) View the words in descending order by word count"
							+ "\n3) View a report on the internal structure of the hash table");
		}

		// if 1, show selected word count and its linked list length
		if (menuChoice == 1) {
			System.out.println("Enter a word to get it's count: ");
			String word = sc.nextLine().toLowerCase();

			// connect with naive/sophist
			System.out.println("Word Count: " + hashType.getWordCount(word) + "\n Linked List Length: "
					+ hashType.getLinkedListLength(word));
		}

		// if 2, show words in descending order
		if (menuChoice == 2) {
			// show words in descending order of word count
			ArrayList<LinkedHashEntry> sorted = hashType.putInDescendingOrder();
			for (LinkedHashEntry e : sorted) {
				System.out.println(e.key + ": " + e.value);
			}
			System.out.println("");
		}
		// if 3, show report on internals of hash table
		if (menuChoice == 3) {
			hashType.printHashTable();
		}

		// gove option to do another menu option
		String menuAgain = goAgain(sc, "Menu");
		return menuAgain;
	}

	private static int chooseHash(Scanner sc) {
		// ask the user for their choice of hash type returns user choice
		System.out.println("Which hash function would you like:" + "\n1) Naive" + "\n2) Sophisticated ");
		int input = sc.nextInt();
		sc.nextLine();

		// input validation for hash type
		while (input != 1 && input != 2) {
			System.out.println("Invalid Entry. Enter 1 or 2.");
			System.out.println("Which hash function would you like:" + "\n1) Naive" + "\n2) Sophisticated ");
			input = sc.nextInt();
			sc.nextLine();
		}

		return input;
	}

}
