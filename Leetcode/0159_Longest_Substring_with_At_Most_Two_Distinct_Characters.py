class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if n < 3:
            return n
        result, i, j = 0, 0, 0
        d = {}
        while i < n and j < n:
            if len(d) < 2 or (len(d) == 2 and s[j] in d):
                d[s[j]] = j
                j += 1
            else:
                index = min(d.values())
                del d[s[index]]
                i = index + 1
                d[s[j]] = j
            result = max(result, j - i)
        return result