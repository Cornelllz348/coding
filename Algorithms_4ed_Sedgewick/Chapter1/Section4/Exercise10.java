package chapter0104;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

// modify binary search so that it always returns the element with the smallest index
// that matches the search element; O(logn)

public class Exercise10 {
	
	// test client
	public static void main(String[] args) {
		 // 1,1,2,2,2,2,2,2,3,3,3,4,4; target = 2; index = 2
		int[] testArray = {2,3,4,2,2,2,1,3,2,2,1,3,4};
		int target = 2;
		Arrays.sort(testArray);
		StdOut.println("Returns index: " + BinarySearch(testArray, target) + "; Expected: 2");
	}
	
	public static int BinarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (array[left] == target) {
			return left;
		}
		if (array[right] == target) {
			return right;
		}
		return -1;
	}
}