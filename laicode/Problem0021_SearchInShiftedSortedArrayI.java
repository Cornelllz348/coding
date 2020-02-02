package allProblems;

import java.util.Scanner;

/*Given a target integer T and an integer array A, 
A is sorted in ascending order first, then shifted by 
an arbitrary number of positions.

For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). 
Find the index i such that A[i] == T or return -1 if 
there is no such index.*/

// method: binary search
// data structure: array
// time: O(logn)
// space: O(1)
// assumption: there is no duplicate elements in the array

public class Problem0021_SearchInShiftedSortedArrayI {
	public static int search(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			}
			if (array[left] == target) {
				return left;
			}
			if (array[right] == target) {
				return right;
			}
			// if the left -> right interval contains the pivot point
			// array[left] must be greater than array[right]
			if (array[left] > array[right]) {
				// if array[mid] is greater than array[left]
				// the pivot is mid or to the right of mid
				// the left -> mid interval is increasing
				if (array[mid] > array[left]) {
					// if target is in between array[left] and array[mid]
					// choose the left half
					if (array[left] < target && target < array[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				} else {
					// if array[mid] is less than array[left]
					// the pivot is mid or to the left of mid
					if (array[mid] < target && target < array[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			} else {
				// if array[left] < array[right]
				// the left -> right interval is increasing
				// then do classic binary search
				if (array[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int target = s.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		System.out.println(search(array, target));
	}
	
}