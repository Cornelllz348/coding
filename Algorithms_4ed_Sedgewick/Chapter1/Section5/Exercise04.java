package chapter0105;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise04 {
	
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	private int[] sz; // size of component of roots (site indexed)
	
	// initialize component id array
	public Exercise04(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		// initialize size of each site to be 1
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			sz[i] = 1;
		}
	}
	
	// return number of components
	public int count() {
		return count;
	}
	
	// return true if p and q are in the same component
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	// component identifier for p
	public int find(int p) {
		// if p is not a root (i.e. p != id[p]), find root of p
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}
	
	// add connection between p and q
	public void union(int p, int q) {
		// give p and q the same root
		int i = find(p);
		int j = find(q);
		if (i == j) {
			return;
		}
		// MAKE SMALLER ROOT POINT TO LARGER ONE
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		StdOut.println("p = " + p + "; q = " + q);
		StdOut.println("i = " + i + "; j = " + j);
		StdOut.println("    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}");
		StdOut.println("id: " + Arrays.toString(id));
		StdOut.println("sz: " + Arrays.toString(sz));
		StdOut.println("sz[i] = " + sz[i] + "; sz[j] = " + sz[j]);
		count--;
	}
	
	// solve dynamic connectivity problem on StdIn
	public static void main(String[] args) {
		int n = StdIn.readInt();
		Exercise04 uf = new Exercise04(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) {
				continue;
			}
			uf.union(p, q);
		}
		StdOut.println(uf.count() + " components");
	}

}

//reference input:
//10
//4 3
//p = 4; q = 3
//i = 4; j = 3
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 1, 2, 4, 4, 5, 6, 7, 8, 9]
//sz: [1, 1, 1, 1, 2, 1, 1, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//3 8
//p = 3; q = 8
//i = 4; j = 8
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 1, 2, 4, 4, 5, 6, 7, 4, 9]
//sz: [1, 1, 1, 1, 3, 1, 1, 1, 1, 1]
//sz[i] = 3; sz[j] = 1
//6 5
//p = 6; q = 5
//i = 6; j = 5
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 1, 2, 4, 4, 6, 6, 7, 4, 9]
//sz: [1, 1, 1, 1, 3, 1, 2, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//9 4
//p = 9; q = 4
//i = 9; j = 4
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 1, 2, 4, 4, 6, 6, 7, 4, 4]
//sz: [1, 1, 1, 1, 4, 1, 2, 1, 1, 1]
//sz[i] = 1; sz[j] = 4
//2 1
//p = 2; q = 1
//i = 2; j = 1
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 2, 2, 4, 4, 6, 6, 7, 4, 4]
//sz: [1, 1, 2, 1, 4, 1, 2, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//8 9
//5 0
//p = 5; q = 0
//i = 6; j = 0
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [6, 2, 2, 4, 4, 6, 6, 7, 4, 4]
//sz: [1, 1, 2, 1, 4, 1, 3, 1, 1, 1]
//sz[i] = 3; sz[j] = 1
//7 2
//p = 7; q = 2
//i = 7; j = 2
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [6, 2, 2, 4, 4, 6, 6, 2, 4, 4]
//sz: [1, 1, 3, 1, 4, 1, 3, 1, 1, 1]
//sz[i] = 1; sz[j] = 3
//6 1
//p = 6; q = 1
//i = 6; j = 2
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
//sz: [1, 1, 3, 1, 4, 1, 6, 1, 1, 1]
//sz[i] = 6; sz[j] = 3
//1 0
//6 7

//---------------------------------------------------
//worst-case input:
//10
//0 1
//p = 0; q = 1
//i = 0; j = 1
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 2, 3, 4, 5, 6, 7, 8, 9]
//sz: [2, 1, 1, 1, 1, 1, 1, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//2 3
//p = 2; q = 3
//i = 2; j = 3
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 2, 2, 4, 5, 6, 7, 8, 9]
//sz: [2, 1, 2, 1, 1, 1, 1, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//4 5
//p = 4; q = 5
//i = 4; j = 5
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 2, 2, 4, 4, 6, 7, 8, 9]
//sz: [2, 1, 2, 1, 2, 1, 1, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//6 7
//p = 6; q = 7
//i = 6; j = 7
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 2, 2, 4, 4, 6, 6, 8, 9]
//sz: [2, 1, 2, 1, 2, 1, 2, 1, 1, 1]
//sz[i] = 2; sz[j] = 1
//0 2
//p = 0; q = 2
//i = 0; j = 2
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 0, 2, 4, 4, 6, 6, 8, 9]
//sz: [4, 1, 2, 1, 2, 1, 2, 1, 1, 1]
//sz[i] = 4; sz[j] = 2
//4 6
//p = 4; q = 6
//i = 4; j = 6
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 0, 2, 4, 4, 4, 6, 8, 9]
//sz: [4, 1, 2, 1, 4, 1, 2, 1, 1, 1]
//sz[i] = 4; sz[j] = 2
//0 4
//p = 0; q = 4
//i = 0; j = 4
//    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
//id: [0, 0, 0, 2, 0, 4, 4, 6, 8, 9]
//sz: [8, 1, 2, 1, 4, 1, 2, 1, 1, 1]
//sz[i] = 8; sz[j] = 4
