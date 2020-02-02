package problems0001to0100;
import java.util.*;

// 1700 - brute force, games, implementation - accepted
public class Problem0003C_TicTacToe {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] crossRow = new int[3];
		int[] noughtRow = new int[3];
		int[] crossCol = new int[3];
		int[] noughtCol = new int[3];
		int[] diag = new int[4];
		int crossCount = 0;
		int noughtCount = 0;
		for (int i = 0; i < 3; i++) {
			String row = s.next();
			if (row.charAt(0) == 'X') {
				crossCount += 1;
				crossCol[0] += 1;
				crossRow[i] += 1;
				if (i == 0) {
					diag[0] += 1;
				}
				if (i == 2) {
					diag[1] += 1;
				}
			} else if (row.charAt(0) == '0') {
				noughtCount += 1;
				noughtCol[0] += 1;
				noughtRow[i] += 1;
				if (i == 0) {
					diag[2] += 1;
				}
				if (i == 2) {
					diag[3] += 1;
				}
			}
			if (row.charAt(1) == 'X') {
				crossCount += 1;
				crossCol[1] += 1;
				crossRow[i] += 1;
				if (i == 1) {
					diag[0] += 1;
					diag[1] += 1;
				}
			} else if (row.charAt(1) == '0') {
				noughtCount += 1;
				noughtCol[1] += 1;
				noughtRow[i] += 1;
				if (i == 1) {
					diag[2] += 1;
					diag[3] += 1;
				}
			}
			if (row.charAt(2) == 'X') {
				crossCount += 1;
				crossCol[2] += 1;
				crossRow[i] += 1;
				if (i == 0) {
					diag[1] += 1;
				}
				if (i == 2) {
					diag[0] += 1;
				}
			} else if (row.charAt(2) == '0') {
				noughtCount += 1;
				noughtCol[2] += 1;
				noughtRow[i] += 1;
				if (i == 0) {
					diag[3] += 1;
				}
				if (i == 2) {
					diag[2] += 1;
				}
			}
		}
		// illegal
		if (crossCount - noughtCount > 1 
				|| noughtCount - crossCount > 0
				|| crossCol[0] + noughtCol[1] == 6
				|| crossCol[0] + noughtCol[2] == 6
				|| crossCol[1] + noughtCol[2] == 6
				|| crossRow[0] + noughtRow[1] == 6
				|| crossRow[0] + noughtRow[2] == 6
				|| crossRow[1] + noughtRow[2] == 6
				|| (crossCount - noughtCount == 1 && (noughtRow[0] == 3
				|| noughtRow[1] == 3 || noughtRow[2] == 3 
				|| noughtCol[0] == 3 || noughtCol[1] == 3 || noughtCol[2] == 3
				|| diag[2] == 3 || diag[3] == 3))
				|| (crossCount == noughtCount && (crossRow[0] == 3
				|| crossRow[1] == 3 || crossRow[2] == 3 
				|| crossCol[0] == 3 || crossCol[1] == 3 || crossCol[2] == 3
				|| diag[0] == 3 || diag[1] == 3)) ){
			System.out.println("illegal");
		} else if (crossCol[0] == 3 || crossCol[1] == 3 || crossCol[2] == 3
				|| crossRow[0] == 3 || crossRow[1] == 3 || crossRow[2] == 3
				|| diag[0] == 3 || diag[1] == 3) {
			System.out.println("the first player won");
		} else if (noughtCol[0] == 3 || noughtCol[1] == 3 || noughtCol[2] == 3
				|| noughtRow[0] == 3 || noughtRow[1] == 3 || noughtRow[2] == 3
				|| diag[2] == 3 || diag[3] == 3) {
			System.out.println("the second player won");
		} else if (crossCount == noughtCount && crossCount + noughtCount < 9) {
			System.out.println("first");
		} else if (crossCount == noughtCount + 1 && crossCount + noughtCount < 9) {
			System.out.println("second");
		} else {
			System.out.println("draw");
		}
		// System.out.println(crossRow[0]);
		// System.out.println(noughtRow[2]);
		// System.out.println(Arrays.toString(diag));
	}

}
