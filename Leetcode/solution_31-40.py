

# -----

# 35. Search Insert Position *

# Given a sorted array of distinct integers and a target value, return the index if the target is found. 
# If not, return the index where it would be if it were inserted in order.

def searchInsert(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    left = 0
    right = len(nums) - 1
    while left < right - 1:
        mid = left + (right - left) // 2
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            right = mid
        else:
            left = mid
    if target <= nums[left]:
        return left
    elif target > nums[right]:
        return right + 1
    else: return left + 1
    
# Method: Binary Search
# Time: O(logN)
# Space: O(1)

# -----
