package leetcode;

import java.util.*;

public class P0051_N_Queens {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();
        
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyBoard[i][j] = '.';
            }
        }
        
        backtrack(0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), emptyBoard);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            String currentRow = new String(state[i]);
            board.add(currentRow);
        }
        return board;
    }
    
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;    
            }

            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
        
    }
}