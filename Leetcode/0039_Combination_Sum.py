class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        result = []
        
        def backtrack(remain, combination, start):
            if remain == 0:
                result.append(list(combination))
            elif remain < 0:
                return
            for i in range(start, len(candidates)):
                # append the number into the combination
                combination.append(candidates[i])
                # give the current number another chance rather than moving on
                backtrack(remain - candidates[i], combination, i)
                # remove the number from the combination
                combination.pop()
        
        backtrack(target, [], 0)
        
        return result