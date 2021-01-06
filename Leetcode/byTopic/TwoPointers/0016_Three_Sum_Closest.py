class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        diff = float('inf')
        for i in range(len(nums)):
            # two pointers approach
            j = i + 1
            k = len(nums) - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                # if abs(diff) is smaller than current diff, update the current diff
                if abs(target - s) < abs(diff):
                    diff = target - s
                if s < target:
                    j = j + 1
                else:
                    k = k - 1
            # if diff is 0 there is no need to proceed as this is definitely closest
            if diff == 0:
                break
        return target - diff