package allProblems;

import java.util.*;

/*Given a matrix of size N x M. 
For each row the elements are sorted in ascending order, 
and for each column the elements are also sorted in 
ascending order. Find the Kth smallest number in it.*/

//method: heapify, best first search
//data structure: heap
//time: O(k)
//space: O(k)

public class Problem0026_KthSmallestNumberInSortedMatrix {
	public static int kthSmallest(int[][] matrix, int k) {
		int N = matrix.length;
		int M = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new myComparator());
		boolean[][] visited = new boolean[N][M];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < N && !visited[cur.row + 1][cur.column]) {
				minHeap.offer(new Cell(cur.row + 1, cur.column,matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}
			if (cur.column + 1 < M && !visited[cur.row][cur.column + 1]) {
				minHeap.offer(new Cell(cur.row, cur.column + 1,matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}
		return minHeap.peek().value;
	}
	
	// min heap comparator
	public static class myComparator implements Comparator<Cell> {
		@Override
		public int compare(Cell c1, Cell c2) {
			if (c1.value == c2.value) {
				return 0;
			}
			return c1.value < c2.value ? -1 : 1;
		}
	}
	
	static class Cell {
		int row;
		int column;
		int value;
		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}
}
