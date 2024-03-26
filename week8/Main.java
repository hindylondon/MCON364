package week8;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.Attributes.Name;
import java.util.stream.*;

import java.util.Comparator;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		ArrayList<ShulMember> arr = new ArrayList<>();

		// Create ShulMember objects and add them to the list
		arr.add(new ShulMember("Smith", "Bob", LocalDate.of(1997, 2, 10), "Kim", "Smith",
				new String[] { "Joe", "Amalia", "Sally" }, 10));
		arr.add(new ShulMember("Johnson", "Alice", LocalDate.of(1975, 8, 20), "John", "Johnson",
				new String[] { "Mike", "Bella", "Jane", "Harry" }, 5));
		arr.add(new ShulMember("Garcia", "Carlos", LocalDate.of(1980, 4, 5), "Maria", "Garcia",
				new String[] { "Pedro", "Ariana" }, 8));

		System.out.println("Shul Members: ");
		printArrayExample(arr);
		System.out.println();

		System.out.println("Number of Families: " + arr.size() + "\n");

		System.out.println("Sorted Membership Years: ");
		sortWithComparatorMembershipYears(arr);
		System.out.println();

		System.out.println("Sorted Ages from Oldest to Youngest: ");
		sortWithComparatorAge(arr);
		System.out.println();

		System.out.println("Sorted Names of all the Spouses: ");
		sortWithComparatorSpouse(arr);
		System.out.println();

		System.out.println("Members with more than 3 children: ");
		filterOnlyMoreThan3Kids(arr);
		System.out.println();

		System.out.println("Kids whose name is larger than C: ");
		filterOnlyKidsLargerThanC(arr);
		System.out.println();
	}

	public static void printArrayExample(ArrayList<ShulMember> arr) {
		// written as a lambda
		arr.forEach(System.out::println);
	}

	public static void sortWithComparatorMembershipYears(ArrayList<ShulMember> arr) {
		// Sort the list of ShulMember objects by age using a Comparator
		arr.stream().sorted(Comparator.comparing(ShulMember::getYearsOfMembership))
				.map(ShulMember::getYearsOfMembership).forEach(System.out::println);

	}

//	// it sorts by age 
	public static void sortWithComparatorAge(ArrayList<ShulMember> arr) {
		// Sort the list of ShulMember objects by age using a Comparator
		arr.stream().sorted(Comparator.comparing(ShulMember::getBirthDateOfMember))
				.forEach(member -> {int age = LocalDate.now().getYear() - member.getBirthDateOfMember().getYear();
				System.out.println(age);
				});
				}

	

	public static void sortWithComparatorSpouse(ArrayList<ShulMember> arr) {
		// Sort the list of ShulMember objects by age using a Comparator
		arr.stream().sorted(Comparator.comparing(ShulMember::getSpouseFirstName)).map(ShulMember::getSpouseFirstName)
				.forEach(System.out::println);

	}

	public static void filterOnlyMoreThan3Kids(ArrayList<ShulMember> arr) {
		Stream<ShulMember> members = arr.stream();
		// Filter 3 or more children
		Stream<ShulMember> filtered = members.filter(n -> n.childrenNames.length > 3);

		// Print the filtered numbers
		filtered.map(ShulMember::getLastNameOfMember).forEach(System.out::println);
	}

	public static void filterOnlyKidsLargerThanC(ArrayList<ShulMember> arr) {
	    Stream<ShulMember> members = arr.stream();

	    // Filter larger than "c" children
	    members
	            .filter(member -> Arrays.stream(member.getChildrenNames())
	                    .anyMatch(name -> name.compareToIgnoreCase("c") > 0))
	            .forEach(member -> {
	                System.out.println("\nFamily: " + member.getLastNameOfMember() + "\nChildren: ");
	                Arrays.stream(member.getChildrenNames())
	                        .filter(name -> name.compareToIgnoreCase("c") > 0)
	                        .forEach(name -> System.out.print(name + " "));
	            });
	}

}
