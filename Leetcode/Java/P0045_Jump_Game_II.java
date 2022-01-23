package leetcode;

public class P0045_Jump_Game_II {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
        	int index = i - 1;
        	int minsteps = Integer.MAX_VALUE;
        	while (index >= 0) {
        		if (nums[index] >= i - index) {
        			minsteps = Math.min(minsteps, dp[index] + 1);
        		}
        		index--;
        	}
        	dp[i] = minsteps;
        }
        return dp[n - 1];
    }
}