package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class P0036_Valid_Sudoku {
	
    public boolean isValidSudoku(char[][] board) {
    	
        ArrayList<HashSet<Character>> row = new ArrayList<>();
        ArrayList<HashSet<Character>> col = new ArrayList<>();
        ArrayList<HashSet<Character>> area = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
        	row.add(new HashSet<Character>());
        	col.add(new HashSet<Character>());
        	area.add(new HashSet<Character>());
        }
        
        for (int i = 0; i < board.length; i++) {			// the ith row
        	for (int j = 0; j < board[0].length; j++) {		// the jth col
        		char c = board[i][j];
        		if (c != '.') {
            		if (row.get(i).contains(c) || col.get(j).contains(c) || area.get(i/3*3 + j/3).contains(c)) {
            			return false;
            		}
            		else {
    	        		row.get(i).add(c);
    	        		col.get(j).add(c);
    	        		area.get(i/3*3 + j/3).add(c);
            		}
        		}
        	}
        }
        
        return true;
    }
    
}