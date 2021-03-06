class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        for i in range(len(nums)):
            a = target - nums[i]
            if a in dict:
                return [dict.get(a), i]
            else:
                dict.update({nums[i]:i})
        return [-1,-1]