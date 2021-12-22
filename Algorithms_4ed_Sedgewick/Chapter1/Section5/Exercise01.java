package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 9-0; 3-4; 5-8; 7-2; 2-1; 5-7; 0-3; 4-2
// p q pID qID	0 1 2 3 4 5 6 7 8 9
// 9 0 	9	0	0 1 2 3 4 5 6 7 8 0	  1 in find(9) + 1 in find(0) + 10 in id[i] == 9 + 1 in updating id[9] = 0 -> 13
// 3 4  3   4   0 1 2 4 4 5 6 7 8 0	  1 in find(3) + 1 in find(4) + 10 in id[i] == 3 + 1 in updating id[3] = 4 -> 13
// 5 8  5   8   0 1 2 4 4 8 6 7 8 0	  1 in find(5) + 1 in find(8) + 10 in id[i] == 5 + 1 in updating id[5] = 8 -> 13
// 7 2  7   2   0 1 2 4 4 8 6 2 8 0	  1 in find(7) + 1 in find(2) + 10 in id[i] == 7 + 1 in updating id[7] = 2 -> 13
// 2 1  2   1   0 1 1 4 4 8 6 1 8 0	  1 in find(2) + 1 in find(1) + 10 in id[i] == 2 + 2 in updating id[2] = 1, id[7] = 1 -> 14
// 5 7  5   1   0 1 1 4 4 1 6 1 1 0	  1 in find(5) + 1 in find(7) + 10 in id[i] == 1 + 2 in updating id[5] = 1, id[8] = 1 -> 14
// 0 3  0   4   4 1 1 4 4 1 6 1 1 4	  1 in find(0) + 1 in find(3) + 10 in id[i] == 0 + 2 in updating id[0] = 4, id[9] = 4 -> 14
// 4 2  4   1   1 1 1 1 1 1 6 1 1 1	  1 in find(4) + 1 in find(2) + 10 in id[i] == 1 + 4 in updating id[0] = 1, id[3] = 1, id[4] = 1, id[9] = 1 -> 16
// total # of array accesses = 13 * 4 + 14 * 3 + 16 = 110

public class Exercise01 {
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		UF_QuickFind uf = new UF_QuickFind(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();			// read pair to connect
			if (uf.connected(p, q)) {			// ignore if connected
				continue;
			}
			uf.union(p, q);						// combine components
			StdOut.println(p + " " + q);		// and print connection
		}
		StdOut.println(uf.count() + " components");
	}

}