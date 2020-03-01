package problems0001to0100;

import java.util.*;

// 1400 - implementation - accepted

public class Problem0006B_PresidentsOffice {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		char c = s.next().charAt(0);
		char[][] M = new char[n][m];
		HashSet<Character> h = new HashSet<Character>(); 
		for (int i = 0; i < n; i++) {
			String str = s.next();
			for (int j = 0; j < m; j++) {
				M[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (M[i][j] == c) {
					if (i > 0 && !h.contains(M[i - 1][j]) && M[i - 1][j] != '.' && M[i - 1][j] != c) {
						h.add(M[i - 1][j]);
					}
					if (i < n - 1 && !h.contains(M[i + 1][j]) && M[i + 1][j] != '.' && M[i + 1][j] != c) {
						h.add(M[i + 1][j]);
					}
					if (j > 0 && !h.contains(M[i][j - 1]) && M[i][j - 1] != '.' && M[i][j - 1] != c) {
						h.add(M[i][j - 1]);
					}
					if (j < m - 1 && !h.contains(M[i][j + 1]) && M[i][j + 1] != '.' && M[i][j + 1] != c) {
						h.add(M[i][j + 1]);
					}
				}
			}
		}
		System.out.println(h.size());
	}

}