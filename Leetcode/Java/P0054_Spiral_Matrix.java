package leetcode;

import java.util.*;

public class P0054_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (m + 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                result.add(matrix[i][j]);
                count++;
            }
            if (count < m * n) {
                for (int j = i + 1; j < m - i; j++) {
                    result.add(matrix[j][n - i - 1]);
                    count++;
                }
            }
            if (count < m * n) {
                for (int j = n - i - 2; j >= i; j--) {
                    result.add(matrix[m - i - 1][j]);
                    count++;
                }
            }
            if (count < m * n) {
                for (int j = m - i - 2; j > i; j--) {
                    result.add(matrix[j][i]);
                    count++;
                }                
            }
        }
        return result;
    }

}
