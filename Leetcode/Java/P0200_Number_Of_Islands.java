package leetcode;

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.

public class P0200_Number_Of_Islands {
	
	private boolean[][] marked;
	private int nr;
	private int nc;
	private int count;
	
    public int numIslands(char[][] grid) {
    	if (grid == null || grid.length == 0) {
    		return 0;
    	}
    	nr = grid.length;
    	nc = grid[0].length;
    	count = 0;
    	marked = new boolean[nr][nc];
    	for (int i = 0; i < nr; i++) {
    		for (int j = 0; j < nc; j++) {
    			if (grid[i][j] == '1' && !marked[i][j]) {
    				count++;
    				dfs(grid, i, j);
    			}
    		}
    	}
    	return count;
    }
    
	public void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] == '0' || marked[i][j]) {
			return;
		}
		marked[i][j] = true;
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}

}
