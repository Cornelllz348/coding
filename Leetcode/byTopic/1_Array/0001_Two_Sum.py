class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        r = []
        for i in range(len(nums)):
            if d.get(target - nums[i]) == None:
                d.update({nums[i]: i})
            else:
                r.append(d.get(target - nums[i]))
                r.append(i)
        return r
