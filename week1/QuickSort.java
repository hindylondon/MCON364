package week1;

public class QuickSort<T extends Comparable<T>> {

	//quicksort class, recursively goes through list, calls the partition method
	public void quickSort(T[] arr, int low, int high) {
	    if (low < high) {
	        int pivotSpot = partition(arr, low, high);

	        quickSort(arr, low, pivotSpot - 1);
	        quickSort(arr, pivotSpot + 1, high);
	    }
	}

	//designates a pivot, compares the list elements to the pivot and calls for a swap when necessary
	public int partition(T[] arr, int low, int high) {
		T pivot = arr[high];
		System.out.println("The current pivot is: " + pivot);

		int i = low - 1;

		//compares element to pivot and swaps where necessary
		for (int j = low; j <= high - 1; j++) {
			if (arr[j].compareTo(pivot) <= 0) {
				System.out.println(arr[j] + " is less then the pivot (" + pivot + ").\nTime to swap...");
				i++;
				swap(arr, i, j);
			}

		}
		System.out.println("Swapping the pivot...");
		//swaps out the pivot
		swap(arr, i + 1, high);

		return (i + 1);
	}


	//swaps two elements with each other using a temp element
	public void swap(T[] arr, int i, int j) {
		T temp = arr[i];

		arr[i] = arr[j];

		arr[j] = temp;
	}
}
