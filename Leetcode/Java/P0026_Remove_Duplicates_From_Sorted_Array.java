package leetcode;

public class P0026_Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        while (fast < n) {
        	if (nums[fast] == nums[slow]) {
        		fast++;
        	} else {
        		slow++;
        		nums[slow] = nums[fast];
        		fast++;
        	}
        }
        return slow + 1;
    }

}
