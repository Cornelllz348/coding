package allProblems;

import java.util.*;

/*Given an array of integers, sort the elements in the array 
 * in ascending order. The merge sort algorithm should be used 
 * to solve this problem.*/

// method: basic sorting - merge sort
// data structure: array
// time: O(nlogn)
// space: O(n)

public class Problem0009_MergeSort {
	// main method function
	public static int[] mergeSort(int[] array) {
		if (array == null || array.length == 0) {
			return array;
		}
		return mergeSort(array, 0, array.length - 1);
	}
	// mergeSort function that takes the array and the left and right boundary as inputs
	// recursively merge the left and right sub-arrays into a sorted array
	private static int[] mergeSort(int[] a, int l, int r) {
		if (l == r) {
			return new int[] {a[l]};
		}
		int m = l + (r - l) / 2;
		int[] leftA = mergeSort(a, l, m);
		System.out.println("l= " + l);
		System.out.println("left= " + Arrays.toString(leftA));
		int[] rightA = mergeSort(a, m + 1, r);
		System.out.println("r= " + r);
		System.out.println("right= " + Arrays.toString(rightA));
		System.out.println("merge= " + Arrays.toString(merge(leftA, rightA)));
		return merge(leftA, rightA);
	}
	// merge function that merge two sorted arrays into one sorted array
	private static int[] merge(int[] a1, int[] a2) {
		int l1 = a1.length;
		int l2 = a2.length;
		int[] result = new int[l1 + l2];
		int i = 0;
		int j = 0;
		int r = 0;
		while (i < l1 && j < l2) {
			if (a1[i] < a2[j]) {
				result[i + j] = a1[i];
				i++;
			} else {
				result[i + j] = a2[j];
				j++;
			}
			r++;
		}
		while (i < l1) {
			result[r] = a1[i];
			i++;
			r++;
		}
		while (j < l2) {
			result[r] = a2[j];
			j++;
			r++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(mergeSort(input)));
	}
	
}