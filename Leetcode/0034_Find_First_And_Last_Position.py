class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        result = [-1] * 2
        if nums == None or len(nums) == 0:
            return result
        left, right = 0, len(nums) - 1
        index = 0
        while left <= right:
            mid = left + (right - left) // 2
            if target == nums[mid]:
                index = mid
                break
            elif target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        p1 = p2 = index
        while p1 > -1 and nums[p1] == target:
            result[0] = p1
            p1 -= 1
        while p2 < len(nums) and nums[p2] == target:
            result[1] = p2
            p2 += 1
        return result