package leetcode;

public class P0034_Find_First_and_Last_Position {
	
    public int[] searchRange(int[] nums, int target) {
    	int[] result = {-1, -1};
    	int lo = 0, hi = nums.length - 1;
    	while (lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if (target == nums[mid]) {
    			int left = mid, right = mid;
    			while (left >= 0 && nums[left] == target) left--;
    			while (right < nums.length && nums[right] == target) right++;
    			result[0] = left + 1;
    			result[1] = right - 1;
    			return result;
    		} else if (target < nums[mid]) {
    			hi = mid - 1;
    		} else {
    			lo = mid + 1;
    		}
    	}
    	return result;
    }
}