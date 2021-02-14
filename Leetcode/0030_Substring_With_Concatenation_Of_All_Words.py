class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        # e.g. s = "barfoothefoobarman", words = ["foo","bar"]
        n = len(s) # string length; n = 18
        m = len(words) # length of the words list; m = 2
        l = len(words[0]) # length of the words in the words list; l = 3
        d = {} # dictionary stores words and number of occurrence
        result = []
        for i in range(m):
            if words[i] in d:
                d[words[i]] += 1
            else:
                d[words[i]] = 1
        for i in range(n - m * l + 1):
            ref = {}
            count = 0
            for j in range(i, i + m * l, l):
                word = s[j:j + l]
                if word in d:
                    if word in ref:
                        ref[word] += 1
                    else:
                        ref[word] = 1
                    if ref[word] == d[word]:
                        count += 1
                    if count == len(d):
                        result.append(i)
                else:
                    break
        return result