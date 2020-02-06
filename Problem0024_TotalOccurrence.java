package allProblems;

import java.util.Scanner;

/*Given a target integer T and an integer array A sorted in ascending order, 
Find the total number of occurrences of T in A.*/

//method: binary search
//data structure: array
//time: O(log n)
//space: O(1)

public class Problem0024_TotalOccurrence {
	public static int totalOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int first = firstOccurrence(array, target);
		int last = lastOccurrence(array, target);
		if (first == -1 || last == -1) {
			return 0;
		} else {
			return last - first + 1;
		}
	}
	
	private static int firstOccurrence(int[] array, int target) {
		int n = array.length;
		int l = 0;
		int r = n - 1;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			if (target <= array[m]) {
				r = m;
			} else {
				l = m;
			}
		}
		if (target == array[l]) {
			return l;
		}
		if (target == array[r]) {
			return r;
		}
		return -1;
	}
	
	private static int lastOccurrence(int[] array, int target) {
		int n = array.length;
		int l = 0;
		int r = n - 1;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			if (target >= array[m]) {
				l = m;
			} else {
				r = m;
			}
		}
		if (target == array[r]) {
			return r;
		}
		if (target == array[l]) {
			return l;
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
		System.out.println(totalOccurrence(array, target));
	}
}