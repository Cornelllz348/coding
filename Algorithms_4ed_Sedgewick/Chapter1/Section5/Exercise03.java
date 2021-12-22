package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 9-0; 3-4; 5-8; 7-2; 2-1; 5-7; 0-3; 4-2

// p q      0 1 2 3 4 5 6 7 8 9
// 	        0 1 2 3 4 5 6 7 8 9
// 9 0      9 1 2 3 4 5 6 7 8 9  1 in find(9) + 1 in find(0) + 1 in updating parent = 3
// 3 4      9 1 2 3 3 5 6 7 8 9  1 in find(3) + 1 in find(4) + 1 in updating parent = 3
// 5 8      9 1 2 3 3 5 6 7 5 9  1 in find(5) + 1 in find(8) + 1 in updating parent = 3
// 7 2      9 1 7 3 3 5 6 7 5 9  1 in find(7) + 1 in find(2) + 1 in updating parent = 3
// 2 1      9 7 7 3 3 5 6 7 5 9  3 in find(2) + 1 in find(1) + 1 in updating parent = 5
// 5 7      9 7 7 3 3 7 6 7	5 9	 1 in find(5) + 1 in find(7) + 1 in updating parent = 3
// 0 3      9 7 7 9 3 7 6 7 5 9  3 in find(0) + 1 in find(3) + 1 in updating parent = 5
// 4 2      9 7 7 9 3 7 6 7 5 7  5 in find(4) + 3 in find(2) + 1 in updating parent = 9
// total # of array accesses = 3 * 5 + 5 * 2 + 9 = 34

public class Exercise03 {
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		UF_WeightedQuickUnion uf = new UF_WeightedQuickUnion(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
	}

}