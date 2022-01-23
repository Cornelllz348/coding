package leetcode;

public class P0059_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int number = 1;
        for (int i = 0; i < (n+1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = number;
                number++;
            }
            for (int j = i + 1; j < n - i; j++) {
                matrix[j][n - i - 1] = number;
                number++;
            }
            for (int j = n - i - 2; j >= i; j--) {
                matrix[n - i - 1][j] = number;
                number++;
            }
            for (int j = n - i - 2; j >= i + 1; j--) {
                matrix[j][i] = number;
                number++;
            }
        }
        return matrix;
    }
}