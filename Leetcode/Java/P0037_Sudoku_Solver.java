package leetcode;

public class P0037_Sudoku_Solver {
	
	final int n = 3;
	int N = n * n;
	
	int[][] rows = new int[N][N+1];
	int[][] cols = new int[N][N+1];
	int[][] areas = new int[N][N+1];
	
	char[][] board;
	
	boolean sudokuSolved = false;
	
    public void solveSudoku(char[][] board) {
        this.board = board;
        // fill the board with pre-existing numbers
        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		char num = board[i][j];
        		if (num != '.') {
        			int d = Character.getNumericValue(num);
        			placeNumber(d, i, j);
        		}
        	}
        }
        // start backtracking
        backtrack(0, 0);
    }
    
    // if a number d can be placed at board[row][col]
    public boolean canPlace(int d, int row, int col) {
    	int index = (row/n) * n + col / n;
    	return rows[row][d] + cols[col][d] + areas[index][d] == 0;
    }
    
    // place the number d at board[row][col]
    public void placeNumber(int d, int row, int col) {
    	int index = (row/n) * n + col / n;
    	rows[row][d]++;
    	cols[col][d]++;
    	areas[index][d]++;
    	board[row][col] = (char)(d + '0');
    }
    
    // remove the number d at board[row][col]
    public void removeNumber(int d, int row, int col) {
    	int index = (row/n) * n + col / n;
    	rows[row][d]--;
    	cols[col][d]--;
    	areas[index][d]--;
    	board[row][col] = '.';
    }
    
    // call backtrack until we reach a solution
    public void placeNextNumbers(int row, int col) {
    	if (col == N - 1 && row == N - 1) {
    		sudokuSolved = true;
    	} else {
    		if (col == N - 1) {				// if we are at the end of a row, start at the front of next row
    			backtrack(row + 1, 0);
    		} else {						// if we are in the middle of a row, continue with the next col
    			backtrack(row, col + 1);
    		}
    	}
    }
    
    // backtracking process
    public void backtrack(int row, int col) {
    	if (board[row][col] == '.') {
    		for (int d = 1; d < 10; d++) {								// iterate through all candidates 1-9
    			if (canPlace(d, row, col)) {
    				placeNumber(d, row, col);							// place the number
    				placeNextNumbers(row, col); 						// recursive call of backtrack
    				if (!sudokuSolved) removeNumber(d, row, col);		// backtrack step
    			}
    		}
    	} else {
    		placeNextNumbers(row, col);
    	}
    }

}
