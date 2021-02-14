class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        
        def backtrack(nums, start, path, result, remain):
            if remain == 0:
                result.append(path)
                return

            for i in range(start, len(nums)):
                # deduplicate
                if i > start and nums[i] == nums[i - 1]:
                    continue

                if nums[i] > remain:
                    break
                
                # i + 1 to start from the next number
                backtrack(nums, i + 1, path + [nums[i]], result, remain - nums[i])
        
        # sort candidates to more conveniently track duplicates
        backtrack(sorted(candidates), 0, [], result, target)

        return result