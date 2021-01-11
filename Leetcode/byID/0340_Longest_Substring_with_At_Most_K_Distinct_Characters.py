class Solution(object):
    def lengthOfLongestSubstringKDistinct(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """
        n = len(s)
        if n < k:
            return n
        if k == 0:
            return 0
        result, i, j = 0, 0, 0
        d = {}
        while i < n and j < n:
            if len(d) < k or (len(d) == k and s[j] in d):
                d[s[j]] = j
                j += 1
            else:
                index = min(d.values())
                del d[s[index]]
                i = index + 1
                d[s[j]] = j
            result = max(result, j - i)
        return result