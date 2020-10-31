


# -----

# 53. Maximum Subarray *

# Given an integer array nums, find the contiguous subarray (containing at least one number) 
# which has the largest sum and return its sum.

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # nums = [-2,1,-3,4,-1,2,1,-5,4]
        # currSum = maxSum = -2
        currSum = maxSum = nums[0]
        
        for i in range(1, len(nums)):
            # currSum = [-2,1,1,4,3,5,6,1,5]
            # maxSum = [-2,1,1,4,4,5,6,6,6]
            currSum = max(nums[i], currSum + nums[i])
            maxSum = max(maxSum, currSum)
            
        return maxSum
    
# Method: DP
# Time: O(n)
# Space: O(1)

# -----

