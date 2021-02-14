class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1:
            return s
        lists = ["" for i in range(numRows)]
        # keep track of current row number
        row = 0
        # keep track of direction using a boolean variable
        down = False
        for i in range(len(s)):
            lists[row] += s[i]
            # when it's the first or last row, change direction
            if row == 0 or row == numRows - 1:
                down = not down
            if down:
                row = row + 1
            else: row = row - 1
        return "".join(lists)