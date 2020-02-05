package allProblems;
import java.util.*;

public class Problem0023_ShiftPosition {
	public static int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		// if the array has not been shifted, return 0
		if (array[left] < array[right]) {
			return left;
		}
		// if the array has been shifted, do binary search to find the smallest element index
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] < array[left]) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return array[left] > array[right] ? right : left;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		System.out.println(shiftPosition(array));
	}

}