package leetcode;

// nums   -2 1 -3 4 -1 2 1 -5 4
// curr   -2 1 -2 4 3  5 6  1 5			curr = max(num, curr + num)
//  max	  -2 1  1 4 4  5 6  6 6			max = max(curr, max)

public class P0053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int current = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            current = Math.max(num, current + num);
            max = Math.max(current, max);
        }
        return max;
    }
}