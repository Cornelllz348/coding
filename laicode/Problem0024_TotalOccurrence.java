package allProblems;

import java.util.Scanner;

/*Given a target integer T and an integer array A sorted in ascending order, 
Find the total number of occurrences of T in A.*/

//method: binary search
//data structure: array
//time: O(logn)
//space: O(1)

public class Problem0024_TotalOccurrence {
	public static int totalOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1 && array[0] == target) {
			return 1;
		}
		int left = 0;
		int right = array.length - 1;
		int mid = left + (right - left) / 2;
		int count = 0;
		while (left < right - 1) {
			if (array[mid] == target) {
				count += 1;
				break;
			} else if (array[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
			mid = left + (right - left) / 2;
		}
		left = mid - 1;
		right = mid + 1;
		while (left >= 0 && array[left] == target) {
			count += 1;
			left -= 1;
		}
		while (right <= array.length - 1 && array[right] == target) {
			count += 1;
			right += 1;
		}
		return count;
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