package week1;

public class MergeSort<T extends Comparable<T>> {
	
	//calls the mergeSplit method with appropriate parameters
	public T[] mergeSort(T[] arr) {
		
		mergeSplit(arr, 0, arr.length - 1);
		
		return arr;
	}
	
	//splits the list in half recursively until each element is its own list
	public void mergeSplit(T[] arr, int left, int right) {
		if (left < right) {
			System.out.println("Splitting the list in half...");
			int mid = (right + left) / 2;
			
			mergeSplit(arr, left, mid);
			mergeSplit(arr, mid + 1, right);
			
			System.out.println("Each element is its own list. Now its time to combine them in order...");
			
			//calls the mergeTogether method with appropriate parameters
			mergeTogether(arr, left, mid, mid + 1, right);
		}
		
		
	}
	
	//puts each element in order in a temp array and then copies it back over into the original array
	public void mergeTogether(T[] arr, int leftFirst, int leftLast, int rightFirst, int rightLast) {
		//set all the temp elements
		int tempLocation = leftFirst;
		@SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Comparable[rightLast + 1];
		int start = leftFirst;
		
		//go thru and check the order and put in order in the temp array
		while (leftFirst <= leftLast && rightFirst <= rightLast) {
			if (arr[leftFirst].compareTo(arr[rightFirst]) <= 0) {
				System.out.println(arr[leftFirst] + " is less then " + arr[rightFirst] + ". We will put it in before.");
				tempArray[tempLocation++] = arr[leftFirst++];
			}
			else {
				System.out.println(arr[leftFirst] + " is greater then " + arr[rightFirst] + ". We will put it in after.");
				tempArray[tempLocation++] = arr[rightFirst++];
			}
		}
		
		//fill the list with the leftovers from the left list
		while (leftFirst <= leftLast) {
			System.out.println("Filling in the leftovers from the left...");
			tempArray[tempLocation++] = arr[leftFirst++];
		}
		
		//fill the list with the leftovers from the right list
		while (rightFirst <= rightLast) {
			System.out.println("Filling in the leftovers from the right...");
			tempArray[tempLocation++] = arr[rightFirst++];
		}
		
		//copy over from the temp array to the original array
		for(tempLocation = start; tempLocation <= rightLast; tempLocation++) {
			arr[tempLocation] = tempArray[tempLocation];
		}
	}

}