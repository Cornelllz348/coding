package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 9-0; 3-4; 5-8; 7-2; 2-1; 5-7; 0-3; 4-2

// p q      0 1 2 3 4 5 6 7 8 9
// 	        0 1 2 3 4 5 6 7 8 9
// 9 0      0 1 2 3 4 5 6 7 8 0  1 in find(9) + 1 in find(0) + 1 in updating parent = 3
// 3 4      0 1 2 4 4 5 6 7 8 0  1 in find(3) + 1 in find(4) + 1 in updating parent = 3
// 5 8      0 1 2 4 4 8 6 7 8 0  1 in find(5) + 1 in find(8) + 1 in updating parent = 3
// 7 2      0 1 2 4 4 8 6 2 8 0  1 in find(7) + 1 in find(2) + 1 in updating parent = 3
// 2 1      0 1 1 4 4 8 6 2 8 0  1 in find(2) + 1 in find(1) + 1 in updating parent = 3
// 5 7      0 1 1 4 4 8 6 2	1 0	 3 in find(5) + 5 in find(7) + 1 in updating parent = 9
// 								 find(5) = 8 -> find(8) = 8 each (p != id[p]) p = id[p] accesses the array twice 
//								 find(7) = 2 -> find(2) = 1 -> find(1) = 1
// 0 3      4 1 1 4 4 8 6 2 1 0  1 in find(0) + 3 in find(3) + 1 in updating parent = 5
//								 find(0) = 0
//								 find(3) = 4 -> find(4) = 4
// 4 2      4 1 1 4 1 8 6 2 1 0  1 in find(4) + 3 in find(2) + 1 in updating parent = 5
// total # of array accesses = 3 * 5 + 9 + 5 * 2 = 34


public class Exercise02 {
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		UF_QuickUnion uf = new UF_QuickUnion(n);
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