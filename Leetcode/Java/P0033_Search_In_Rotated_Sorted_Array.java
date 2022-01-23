package leetcode;

public class P0033_Search_In_Rotated_Sorted_Array {
	
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
        	int mid = lo + (hi - lo) / 2;
        	if (nums[mid] == target) {
        		return mid;
        	} else if (nums[mid] >= nums[lo]) { // pivot is to the right of mid
        		if (target >= nums[lo] && target < nums[mid]) {
        			hi = mid - 1;
        		} else {
        			lo = mid + 1;
        		}
        	} else {							// pivot is to the left of mid
        		if (target <= nums[hi] && target > nums[mid]) {
        			lo = mid + 1;
        		} else {
        			hi = mid - 1;
        		}
        	}
        }
        return -1;
    }

}
