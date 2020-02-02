package allProblems;
import java.util.*;

/*Given an array of integers, sort the elements in the array 
 * in ascending order. The quick sort algorithm should be used 
 * to solve this problem.*/

// method: basic sorting - quick sort
// data structure: array
// time: worst case O(n^2); average O(nlogn)
// space: O(n)

public class Problem0010_QuickSort {
	static Random rand = new Random();
	// main method function
	public static int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	// quickSort function that takes the array and left and right boundary as inputs
	// recursive rule:
	// * quickSort the sub-array left to the pivot
	// * quickSort the sub-array right to the pivot
	public static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotPos = partition(array, left, right);
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}
	// partition function that makes the numbers left to the pivot smaller than
	// the pivot and the numbers right to the pivot larger than the pivot and
	// returns the left index
	private static int partition(int[] array, int left, int right) {
		int pivotIndex = left + rand.nextInt(right - left + 1);
		int pivot = array[pivotIndex];
		// swap the pivot element to the rightmost position first
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while (leftBound <= rightBound) {
			if (array[leftBound] < pivot) {
				leftBound++;
			} else if (array[rightBound] >= pivot) {
				rightBound--;
			} else {
				swap(array, leftBound, rightBound);
			}
		}
		swap(array, leftBound, right);
		return leftBound;
	}
	// swap function
	private static void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(quickSort(input)));
	}
}
