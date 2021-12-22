package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Repeat exercise 05 for weighted quick-union

// 605 instructions for each input pair * 10^6 input pairs ~ 6 * 10^8 instructions
// which uses 6 * 10^8 / 10^9 = 0.6 seconds

public class Exercise06 {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	private int[] sz; // size of component of roots (site indexed)
	
	// initialize component id array
	public Exercise06(int n) {
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
		int i = find(p);				// each find() function needs at worst lg(10^9) * 10 ~ 300 instructions
		int j = find(q);				// each find() function needs at worst lg(10^9) * 10 ~ 300 instructions
		if (i == j) {					// 1 instruction
			return;
		}
		// MAKE SMALLER ROOT POINT TO LARGER ONE
		if (sz[i] < sz[j]) {			// 1 instruction
			id[i] = j;					// 1 instruction
			sz[j] += sz[i];				// 1 instruction
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;						// 1 instruction
	}
	
	// solve dynamic connectivity problem on StdIn
	public static void main(String[] args) {
		int n = StdIn.readInt();
		Exercise06 uf = new Exercise06(n);
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
