package week3;

import java.util.*;

import week3.BSTInterface.Traversal;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Menu\n" + "1) Automatic BST\n" + "2) User Input BST");

		int choice = sc.nextInt();

		while (choice != 1 && choice != 2) {
			System.out.println("Invalid Entry. Please input 1 or 2.");
			System.out.println("Menu\n" + "1) Automatic BST\n" + "2) User Input BST");

			choice = sc.nextInt();
		}

		if (choice == 1) {
			automaticOutput();
			


		}

		else {
			userTurn();

		}
		sc.close();
	}

	private static void automaticOutput() {
		BST<Integer> bst = new BST<>();
		
		int containsTarget = 6;

		bst.add(3);
		bst.add(2);
		bst.add(5);
		bst.add(4);
		bst.add(1);

		bst.get(4);

		bst.contains(containsTarget);

		bst.remove(2);

		bst.isFull();

		bst.isEmpty();

		bst.size();

		bst.min();

		bst.max();

		bst.getIterator(Traversal.Preorder);
		bst.getIterator(Traversal.Inorder);
		bst.getIterator(Traversal.Postorder);
		bst.getIterator(Traversal.BreadthFirst);
		
		bst.toString();
		
	}

	private static void userTurn() {
		BST<Integer> bst = new BST<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("How many numbers do you have? ");
		int numsLength = sc.nextInt();

		while (numsLength < 1) {
			System.out.println("Invalid Entry. Enter a number greater then 0.");
			System.out.println("How many numbers do you have? ");
			numsLength = sc.nextInt();
		}

		for (int i = 0; i < numsLength; i++) {
			System.out.println("Enter number " + (i + 1) + ": ");
			System.out.println("Adding your number to the BST...");
			bst.add(sc.nextInt());
		}

		String again = "y";
		while (again.equals("y")) {
			System.out.println("Menu\n" + "1) Add an element\n" + "2) Delete an element\n" + "3) Do a Search");

			int userChoice = sc.nextInt();

			while (userChoice < 1 && userChoice > 3) {
				System.out.println("Invalid Entry. Please enter 1 or 2 or 3. ");
				System.out.println("Menu\n" + "1) Add an element\n" + "2) Delete an element\n" + "3) Do a Search");

				userChoice = sc.nextInt();
			}

			if (userChoice == 1) {
				System.out.println("Enter element you want to add: ");
				bst.add(sc.nextInt());
			} else if (userChoice == 2) {
				System.out.println("Enter element you would like to delete: ");
				bst.remove(sc.nextInt());
			} else {
				doSearch(bst);
			}

			System.out.println("Do you want to do something else? (y/n) ");
			String userAgain = sc.next();

			while (!userAgain.equals("y") && !userAgain.equals("n")) {
				System.out.println("Invalid Entry. Please enter y or n.");
				System.out.println("Do you want to do something else? (y/n) ");
				userAgain = sc.next();
			}

			again = userAgain;

		}

	}

	private static void doSearch(BST<Integer> bst) {
		Scanner input = new Scanner(System.in);
		System.out.println("Search Menu\n" + "1) PreOrder\n" + "2) PostOrder\n" + "3) InOrder\n" + "4) BreadthFirst");

		int searchChoice = input.nextInt();

		while (searchChoice < 1 && searchChoice > 4) {
			System.out.println("Invalid Entry. Enter 1,2,3, or 4.");
			System.out
					.println("Search Menu\n" + "1) PreOrder\n" + "2) PostOrder\n" + "3) InOrder\n" + "4) BreadthFirst");

			searchChoice = input.nextInt();
		}

		if (searchChoice == 1) {
			bst.getIterator(Traversal.Preorder);
		} else if (searchChoice == 2) {
			bst.getIterator(Traversal.Postorder);
		} else if (searchChoice == 3) {
			bst.getIterator(Traversal.Inorder);
		} else {
			bst.getIterator(Traversal.BreadthFirst);
		}

	}

}
