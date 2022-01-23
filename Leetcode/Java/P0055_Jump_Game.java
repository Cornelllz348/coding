package leetcode;

import java.util.*;

public class P0055_Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, true);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                dp[i] = false;
                int index = i - 1;
                while (index >= 0) {
                    for (int j = 1; j <= nums[index]; j++) {
                        dp[index] = false;
                        if (dp[index + j] == true) {
                            dp[index] = true;
                            break;
                        }
                    }
                    index--;
                }
            }
        }
        return dp[0];
    }
}
