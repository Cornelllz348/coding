from collections import defaultdict
class Solution:
    def solveSudoku(self, board):
        """
        Do not return anything, modify board in-place instead.
        """
        # if a digit d can be placed at board[row][col]
        # it can be placed if d is not used in its row, its column, and its box
        def can_place(d, row, col):
            if d not in rows[row] and d not in cols[col] and d not in boxes[box(row, col)]:
                return True
            else:
                return False

        # place a digit d at board[row][col]
        # mark that the digit has been used in the corresponding rows, cols, and boxes dict
        def place_number(d, row, col):
            rows[row][d] += 1
            cols[col][d] += 1
            boxes[box(row, col)][d] += 1
            board[row][col] = str(d)
        
        # reverse board[row][col] back to empty
        # delete that digit from its corresponding rows, cols, and boxes dict
        def remove_number(d, row, col):
            del rows[row][d]
            del cols[col][d]
            del boxes[box(row, col)][d]
            board[row][col] = '.'
        
        # proceed to the next cell (using backtracking)
        # if at the right-bottom cell then the sodoku is solved
        # if the row has been filled proceed to the next row
        # else proceed to the next col (on the same row)
        def place_next_numbers(row, col):
            if col == 8 and row == 8:
                nonlocal sudoku_solved
                sudoku_solved = True
            else:
                if col == 8:
                    backtrack(row + 1, 0)
                else:
                    backtrack(row, col + 1)
        
        # if the cell is empty, then loop through 1-9 and place the digit
        # if we can no longer proceed as the solution is invalid, backtrack
        # if the cell is already filled with a digit, then proceed to the next cell
        def backtrack(row, col):
            if board[row][col] == '.':
                for d in range(1, 10):
                    if can_place(d, row, col):
                        place_number(d, row, col)
                        place_next_numbers(row, col)
                        if not sudoku_solved:
                            remove_number(d, row, col)
            else:
                place_next_numbers(row, col)
        
        # lambda function to solve for the box index given a row and col index
        box = lambda row, col: (row // 3) * 3 + col // 3
        
        # rows, cols, boxes are dict of 0's and 1's
        # 0 means the number has not been used in the corresponding row/col/box; 1 means it has
        rows = [defaultdict(int) for i in range(9)]
        cols = [defaultdict(int) for i in range(9)]
        boxes = [defaultdict(int) for i in range(9)]
        
        # translate the original board into dict
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    d = int(board[i][j])
                    place_number(d, i, j)
        
        sudoku_solved = False
        
        # start backtrack from top left
        backtrack(0, 0)