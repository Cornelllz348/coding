class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        n = len(s)
        # dp[i] represents the length of the longest valid parentheses that ends at index i 
        dp = [0] * n
        for i in range(1, n):
            # update dp only when we encounter ')'
            if s[i] == ')':
                # if s[i-1] is '(' then we update dp[i] to be dp[i-2] + 2
                if s[i-1] == '(':
                    if i >= 2:
                        dp[i] = dp[i-2] + 2
                    else:
                        dp[i] = 2
                # if s[i-1] is ')', then we check if the ')' at index i is part of a valid substring
                elif i - dp[i-1] > 0 and s[i - dp[i-1] - 1] == '(':
                    if i - dp[i-1] >= 2:
                        dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
                    else:
                        dp[i] = dp[i-1] + 2
                result = max(result, dp[i])
        return result