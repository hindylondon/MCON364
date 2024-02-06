package week1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//intro
		System.out.println("Welcome to your custom sorter!");
		System.out.println();

		String again = "y";

		//ensure that the user can make as many sorts as desired
		while (again.toLowerCase().equals("y")) {
			//display menu
			System.out.println("Please select an option from the Menu below: ");
			System.out.println("1) See an example of both sorts"
					+ "\n2) Do a QuickSort" 
					+ "\n3) Do a MergeSort");

			//set menu choice
			int choice = input.nextInt();
			
			//input val for users menu choice
			while (choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Invalid Entry. Please enter 1, 2, or 3.");
				System.out.println("Please select an option from the Menu below: ");
				System.out.println("1) See an example of both sorts"
						+ "\n2) Do a QuickSort" 
						+ "\n3) Do a MergeSort");

				choice = input.nextInt();
				
			}
			
			//code for if user chooses 1 - to display a sample of both sorts with hardcoded in list of students
			if (choice == 1) {
				Student[] students = { 
						new Student("a", 89), 
						new Student("b", 67), 
						new Student("c", 96),
						new Student("d", 43), 
						new Student("e", 74) };
				
				//display original list
				System.out.println();
				System.out.println("Original List");
				
				for (Student s : students) {
					System.out.println(s.toString());
				}
				
				//sort the list with a quick sort
				System.out.println();
				System.out.println("-----------------");
				System.out.println("QuickSorted List");
				System.out.println("-----------------");
				System.out.println();
				
				QuickSort<Student> quickSort = new QuickSort<>();
				
				//copy over to new list, so no messes with the original list
				Student[] quickSortStudents = Arrays.copyOf(students, students.length);

				quickSort.quickSort(quickSortStudents, 0, quickSortStudents.length - 1);
				
				//display sorted
				System.out.println();
				System.out.println("The list is sorted!");
				for (Student s : quickSortStudents) {
					System.out.println(s.toString());
				}
				
				//display original list
				System.out.println();
				System.out.println("Original List");
				
				for (Student s : students) {
					System.out.println(s.toString());
				}
				
				//sort the list with a merge sort
				System.out.println();
				System.out.println("-----------------");
				System.out.println("MergeSorted List");
				System.out.println("-----------------");
				System.out.println();
				
				
				MergeSort<Student> mergeSort = new MergeSort<>();
				
				//copy over to new list, so no messes with the original list
				Student[] mergeSortStudents = Arrays.copyOf(students, students.length);
				
				mergeSort.mergeSort(mergeSortStudents);
				
				//display sorted
				System.out.println();
				System.out.println("The list is sorted!");
				for (Student s : mergeSortStudents) {
					System.out.println(s.toString());
				}

				System.out.println();
			}
			
			//if not choice 1, get info about users students
			else {
				//get how many students
				System.out.println("How many students do you have? ");
				int length = input.nextInt();
				
				//input validation for number of students
				while (length < 0) {
					System.out.println("Invalid Entry. Number of students must be a positive number.");
					System.out.println("How many students do you have? ");
					length = input.nextInt();
					
				}
				
				Student[] students = new Student[length];
				
				//set up students info into list of Students
				for (int i = 0; i < length; i++) {
					System.out.println("Enter Student " + (i + 1) + "'s name: ");
					String name = input.next();
					
					System.out.println("Enter Student " + (i + 1) + "'s grade: ");
					int grade = input.nextInt();
					
					//input validation for grade
					while (grade < 0) {
						System.out.println("Invalid Entry. Grade must be a positive number.");
						System.out.println("Enter Student " + (i + 1) + "'s grade: ");
						grade = input.nextInt();
						
					}
					
					students[i] = new Student(name, grade);
				}
			
				
				//if choice is 2, do quick sort and display results
				if (choice == 2) {
					//show original list
					System.out.println("\nOriginal List");
					for (Student s : students) {
						System.out.println(s.toString());
					}

					//do quick sort on the list
					System.out.println("\nQuickSort\n");
					
					QuickSort<Student> qs = new QuickSort<>();
					
					//copy over to new list, so no messes with the original list
					Student[] customQuickSort = Arrays.copyOf(students, students.length);

					qs.quickSort(customQuickSort, 0, length - 1);
					
					//display sorted list
					System.out.println("\nQuickSorted List");
					for (Student s : customQuickSort) {
						System.out.println(s.toString());
					}
					System.out.println();
				}
			
				//if choice is 3, do merge sort and display results
				if (choice == 3) {
					//display original list
					System.out.println("\nOriginal List");
					for (Student s : students) {
						System.out.println(s.toString());
					}
					
					//merge sort the list
					System.out.println("\nMergeSort\n");
					
					MergeSort<Student> mergeSort = new MergeSort<>();
					
					//copy over to new list, so no messes with the original list
					Student[] customMergeSort = Arrays.copyOf(students, students.length);
					
					mergeSort.mergeSort(customMergeSort);
					
					//display sorted list
					System.out.println("\nMergeSorted List");
					for (Student s : customMergeSort) {
						System.out.println(s.toString());
					}
					System.out.println();

				
				}
			
			}

			//ask user if they want any more sorts
			System.out.println("Do you want to do another sort? (y/n) ");
			String repeat = input.next().toLowerCase();
			
			//input validation for going again
			while (!repeat.equals("y") && !repeat.equals("n")) {
				System.out.println("Invalid Entry. Please enter y or n.");
				System.out.println("Do you want to do another sort? (y/n) ");
				repeat = input.next().toLowerCase();
			}
			again = repeat;

		}
		
		//closing
		System.out.println("Goodbye!");
		
		input.close();
	}
	
}
