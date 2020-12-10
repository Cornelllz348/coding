class Solution(object):
    def canPermutePalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        d = {}
        for char in s:
            if char not in d:
                d[char] = 1
            else:
                d[char] += 1
        count_odd = 0
        for key, value in d.items():
            if value % 2 != 0:
                count_odd += 1
            if count_odd > 1:
                return False
        return True