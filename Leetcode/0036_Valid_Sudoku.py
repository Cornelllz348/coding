class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        output = True
        row = [[] for i in range(9)]
        col = [[] for i in range(9)]
        grid = [[] for i in range(9)]
        for i in range(9):
            for j in range(9):
                value = board[i][j]
                igrid = j // 3 * 3 + i // 3
                if value != '.' and (value in row[i] or value in col[j] or value in grid[igrid]):
                    output = False
                    break
                elif value != '.':
                    row[i].append(value)
                    col[j].append(value)
                    grid[igrid].append(value)
        return output