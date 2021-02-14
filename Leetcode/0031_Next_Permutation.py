class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # find a pivot index such that nums[pivot-1] < num[pivot]
        # i.e. this is the first element counting from the end of the list that is non-ascending
        # if pivot is 0 meaning the list is descending, there is no larger permutation than the current
        pivot = len(nums) - 2
        while (pivot >= 0 and nums[pivot+1] <= nums[pivot]):
            pivot = pivot - 1
        if pivot >= 0:
            j = len(nums) - 1
            while (j >= 0 and nums[j] <= nums[pivot]):
                j = j - 1
            swap(nums, pivot, j)
        reverse(nums, pivot+1)

# swap two elements in a list
def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

# reverse the end of the list starting from the element start   
def reverse(nums, start):
    i = start
    j = len(nums)-1
    while i < j:
        swap(nums, i, j)
        i = i + 1
        j = j - 1