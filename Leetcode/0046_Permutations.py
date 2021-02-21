class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        def backtrack(first):
            # base case
            if first == n:
                output.append(nums[:])
            # recursive rule:
            for i in range(first, n):
                # swap numbers at index first and i
                swap(nums, first, i)
                # recursively call to advance first
                backtrack(first + 1)
                # swap again to backtrack
                swap(nums, first, i)
        
        def swap(nums, i, j):
            tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            
        n = len(nums)
        output = []
        backtrack(0)
        return output