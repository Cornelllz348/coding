class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        # [1     1     2]
        #  start
        def backtrack(combination, counter):
            # base case
            if len(combination) == n:
                results.append(list(combination))
                return
            
            # use hashmap to deduplicate (only looping through unique numbers in the counter)
            for num in counter:
                if counter[num] > 0:
                    # append the number, reduce counter of that number
                    combination.append(num)
                    counter[num] -= 1
                    # recursion
                    backtrack(combination, counter)
                    # backtrack to revert
                    combination.pop()
                    counter[num] += 1
        
        results = []
        n = len(nums)
        backtrack([], Counter(nums))
        
        return results