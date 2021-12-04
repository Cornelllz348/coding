package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Quick Union implementation of Union Find
// rather than arbitrarily connecting the second tree to the first for union(),
// we keep track of the size of each tree and always connect the smaller tree to the larger one

public class UF_WeightedQuickUnion {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	private int[] sz; // size of component of roots (site indexed)
	
	// initialize component id array
	public UF_WeightedQuickUnion(int n) {
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
		count--;
	}
	
	// solve dynamic connectivity problem on StdIn
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
