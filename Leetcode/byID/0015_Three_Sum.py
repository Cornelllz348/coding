class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        nums.sort()
        result = []
        for i in range(n - 2):
            if nums[i] > 0:
                break
            if i == 0 or nums[i - 1] != nums[i]:
                j = i + 1
                k = n - 1
                while j < k:
                    total = nums[i] + nums[j] + nums[k]
                    if total < 0:
                        j += 1
                    elif total > 0:
                        k -= 1
                    else:
                        result.append([nums[i], nums[j], nums[k]])
                        j += 1
                        k -= 1
                        while j < k and nums[j] == nums[j - 1]:
                            j += 1
        return result