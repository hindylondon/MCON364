package week1;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SortTests {
	QuickSort<Integer> qs = new QuickSort<>();
	

	@Test
	void testThatSwapInQuickSortWorks() {
		Integer[] nums = {1,2};
		
		qs.swap(nums, 0, 1);
		
		Integer[] expected = {2,1};
		
		assert Arrays.equals(nums, expected);
	}
	
	@Test
	void testThatMergeSortWorksWithStudent() {
		Student[] students = { 
				new Student("a", 89), 
				new Student("b", 67), 
				new Student("c", 96),
				new Student("d", 43), 
				new Student("e", 74) };
		
		MergeSort<Student> ms = new MergeSort<>();
		
		ms.mergeSort(students);
		
		Student[] expected = { 
				new Student("d", 43),
				new Student("b", 67), 
				new Student("e", 74), 
				new Student("a", 89),
				new Student("c", 96)};
		
		
		assert Arrays.equals(students, expected);
	}
	
	@Test
	void testThatQuickSortCorrectlySortsAListOfInts() {
		Integer[] nums = {7,9,4,6,1};
		
		Integer[] expected = {1,4,6,7,9};
		
		qs.quickSort(nums, 0, nums.length - 1);
		
		assert Arrays.equals(nums, expected);
	}
	
	@Test
	void testThatMergeSortCorrectlySortsAListOfStrings() {
		String[] words = {"happy", "birthday", "dear", "best", "friend"};
		
		String[] expected = {"best", "birthday", "dear", "friend", "happy"};
		
		MergeSort<String> ms = new MergeSort<>();
		
		ms.mergeSort(words);
		
		assert Arrays.equals(words, expected);
	}

}
