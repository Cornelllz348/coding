package allProblems;

public class Problem0019_KClosestInSortedArray {
	
	public int[] kClosest(int[] array, int target, int k) {
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			if (right >= array.length || left >= 0 && Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
				result[i] = array[left];
				left = left - 1;
			} else {
				result[i] = array[right];
				right = right + 1;
			}
		}
		return result;
	}

}
