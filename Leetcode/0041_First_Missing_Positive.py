class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if 1 is not in nums, return 1
        if len(nums) == 0 or 1 not in nums:
            return 1
        
        # e.g. nums = [1,2,3,5,6,7]
        nums1 = []
        for i in range(len(nums)):
            if nums[i] >= 0 and nums[i] not in nums1:
                nums1.append(nums[i])
        
        # then nums1 = [1,2,3,5,6,7] and n = 6
        n = len(nums1)
        d = [0] * 300
        # d = [2,1,1,0,1,1,0,.........]
        #      0 1 2 3 4 5 6
        for i in range(n):
            if nums1[i] > n:
                d[0] += 1
            else:
                d[nums1[i] - 1] += 1
        
        for i in range(300):
            if d[i] == 0:
                return i+1