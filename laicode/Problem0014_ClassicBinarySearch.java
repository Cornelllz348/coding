package allProblems;

import java.util.Scanner;

/*Given a target integer T and an integer array A sorted in 
ascending order, find the index i such that A[i] == T 
or return -1 if there is no such index.*/

// method: binary search
// data structure: array
// time: O(logn)
// space: O(1)

public class Problem0014_ClassicBinarySearch {
	public static int classicBinarySearch(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int n = array.length;
		int l = 0;
		int r = n - 1;
		while (r >= l) {
			int m = l + (r - l) / 2;
			if (target == array[m]) {
				return m;
			} else if (target < array[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		int target = s.nextInt();
		System.out.println(classicBinarySearch(array, target));
	}
}