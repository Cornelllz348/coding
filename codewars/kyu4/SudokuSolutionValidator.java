package kyu4;
import java.util.*;

public class SudokuSolutionValidator {
	public static boolean check(int[][] sudoku) {
		boolean result = true;
		List<HashSet<Integer>> colCheck = new ArrayList<HashSet<Integer>>();
		List<HashSet<Integer>> blockCheck = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < 9; i++) {
			colCheck.add(i, new HashSet<Integer>());
			blockCheck.add(i, new HashSet<Integer>());
		}
		for (int i = 0; i < 9; i++) {
			HashSet<Integer> rowCheck = new HashSet<Integer>();
			for (int j = 0; j < 9; j++) {
				int num = sudoku[i][j];
				if (num == 0) {
					return false;
				}
				if ((!rowCheck.isEmpty() && rowCheck.contains(num)) 
						|| (!colCheck.get(i).isEmpty() && colCheck.get(i).contains(num))
						|| (!blockCheck.get(i / 3 * 3 + j / 3).isEmpty() && blockCheck.get(i / 3 * 3 + j / 3).contains(num))) {
					return false;
				}
				rowCheck.add(num);
				colCheck.get(i).add(num);
				blockCheck.get(i / 3 * 3 + j / 3).add(num);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(sudoku));
	}
}