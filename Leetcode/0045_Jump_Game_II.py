class Solution:
    def jump(self, nums: List[int]) -> int:
        # 0 1 2 3 4 5 6 7 8
        # 2 3 1 1 4 2 3 1 2
        # l i r   j 
        #   ------>
        n = len(nums)
        if n < 2:
            return 0
        # initialize left and right pointer to be the length of one jump
        l, r = 0, nums[0]
        jumps = 1
        # look for the farthest index to which an extra jump can be made from within left and right
        # update left pointer to be right pointer and update right pointer to that index
        while r < n - 1:
            jumps += 1
            j = 0
            for i in range(l, r + 1):
                j = max(i + nums[i], j)
            l = r
            r = j
        return jumps