package allProblems;

import java.util.*;

/* Given an array of integers, 
 * sort the elements in the array in ascending order. 
 * The selection sort algorithm should be used
 * */

// method: basic sorting
// data structure: array
// time: O(n^2)
// space: O(1)

public class Problem0004_SelectionSort {
	public static int[] selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			// for each iteration select global min
			// in the subarray [i + 1, n)
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			// swap the global min with the i-th element
			int tmp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = tmp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(selectionSort(A)));
	}
}