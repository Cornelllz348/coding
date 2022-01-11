package leetcode;

public class P0027_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0, n = nums.length;
        while (fast < n) {
        	if (nums[fast] == val) {
        		fast++;
        	} else {
        		nums[slow] = nums[fast];
        		slow++;
        		fast++;
        	}
        }
        return slow;
    }
}