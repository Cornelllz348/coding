package leetcode;

// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

public class P0042_Trapping_Rain_Water {
	
	// T: O(n^2); S: O(1)
    public int trap_BruteForce(int[] height) {
    	if (height == null || height.length <= 2) {
    		return 0;
    	}
    	int result = 0;
    	for (int i = 1; i < height.length; i++) {
    		int p = i - 1;
    		int q = i + 1;
    		int leftMax = height[i];
    		int rightMax = height[i];
    		while (p >= 0) {
    			leftMax = Math.max(height[p], leftMax);
    			p--;
    		}
    		while (q < height.length) {
    			rightMax = Math.max(height[q], rightMax);
    			q++;
    		}
    		result += Math.min(leftMax, rightMax) - height[i];
    	}
    	return result;
    }
    
    // T: O(n); S: O(n)
    public int trap_DP(int[] height) {
    	if (height == null || height.length <= 2) {
    		return 0;
    	}
    	int result = 0;
    	int n = height.length;
    	int[] leftMax = new int[n];
    	int[] rightMax = new int[n];
    	leftMax[0] = height[0];
    	rightMax[n - 1] = height[n - 1];
    	for (int i = 1; i < n; i++) {
    		leftMax[i] = Math.max(height[i - 1], leftMax[i - 1]);
    	}
    	for (int i = n - 2; i >= 0; i--) {
    		rightMax[i] = Math.max(height[i + 1], rightMax[i + 1]);
    	}
    	for (int i = 1; i < n; i++) {
    		result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
    	}
    	return result;
    }
}
