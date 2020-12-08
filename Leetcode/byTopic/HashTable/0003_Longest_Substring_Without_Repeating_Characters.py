class Solution(object):
    # sliding window
    """
    def lengthOfLongestSubstring(self, s):
        ans = p1 = p2 = 0
        d = set()
        while p1 < len(s) and p2 < len(s):
            if (s[p2] not in d):
                d.add(s[p2])
                p2 += 1
                ans = max(ans, p2 - p1)
            else:
                d.remove(s[p1])
                p1 += 1
        return ans
    """
    # sliding window optimized
    def lengthOfLongestSubstring(self, s):
        # define a mapping of char to its index
        M = {}
        result = 0
        i = 0
        for j in range(len(s)):
            # if repeated char is found, update i to be j + 1
            if s[j] in M:
                i = max(i, M[s[j]])
            result = max(result, j - i + 1)
            M[s[j]] = j + 1
        return result