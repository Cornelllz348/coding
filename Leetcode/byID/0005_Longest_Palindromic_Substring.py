class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        p1 = p2 = 0
        for i in range(len(s)):
            # case 1: palindrome is of odd length
            l1 = self.expandAroundCenter(s, i, i)
            # case 2: palindrome is of even length
            l2 = self.expandAroundCenter(s, i, i+1)
            l = max(l1, l2)
            # allocate length to left and right part around i
            if (l > p2 - p1):
                p1 = i - (l - 1) // 2
                p2 = i + l // 2
        return s[p1:p2+1]
    
    def expandAroundCenter(self, s, left, right):
        # expand around center and return length of the palindromic substring
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left = left - 1
            right = right + 1
        return right - left - 1