class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return
        
        # l: amount of left parentheses remaining
        # r: amount of right parentheses remaining
        # combination: current combination
        # result: result combination
        
        def backtrack(l, r, combination, result):
            # invalid combination if more right parentheses than left ones are used
            if r < l:
                return
            # append current combination if there are no more left or right parentheses remaining
            if l == 0 and r == 0:
                result.append(combination)
            # if there are still left parentheses, append (
            if l > 0:
                backtrack(l - 1, r, combination + '(', result)
            # if there are still right parentheses, append )
            if r > 0:
                backtrack(l, r - 1, combination + ')', result)
        
        result = []
        backtrack(n, n, '', result)
        return result