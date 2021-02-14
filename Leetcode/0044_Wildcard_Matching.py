class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        # s: string; p: pattern
        s_len = len(s)
        p_len = len(p)
        
        # base cases:
        if p == s or p == '*':
            return True
        if p == '' and s == '':
            return False
        
        # initialize 2d dp matrix as a (s_len + 1) x (p_len + 1) matrix with all False except for d[0][0]
        d = [[False] * (s_len + 1) for _ in range(p_len + 1)]
        d[0][0] = True
        
        for p_index in range(1, p_len + 1):
            # if current char is a '*':
            if p[p_index - 1] == '*':
                # check for the first match on the previous step
                s_index = 1
                while not d[p_index - 1][s_index - 1] and s_index < s_len + 1:
                    s_index += 1
                # '*' at the end of the pattern still results a match
                d[p_index][s_index - 1] = d[p_index - 1][s_index - 1]
                # '*' could match all chars to the end of the string
                while s_index < s_len + 1:
                    d[p_index][s_index] = True
                    s_index += 1
            # if current char is a '?'
            elif p[p_index - 1] == '?':
                # True if top left corner is True as '?' can represent any single char
                for s_index in range(1, s_len + 1):
                    d[p_index][s_index] = d[p_index - 1][s_index - 1]
            # if current char is neither '*' nor '?'
            else:
                # True if top left corner is True and char match
                for s_index in range(1, s_len + 1):
                    d[p_index][s_index] = (d[p_index - 1][s_index - 1] and p[p_index - 1] == s[s_index - 1])
        
        return d[p_len][s_len]