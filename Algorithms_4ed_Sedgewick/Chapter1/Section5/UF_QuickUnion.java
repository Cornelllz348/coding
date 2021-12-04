package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Quick Union implementation of Union Find
// two sites are in the same component iff they have the same root
// union changes only one link (unlike in quick-find changes between 1 and n-1 of them)
// union[] always takes linear time, while find[] needs 2n-1 array accesses in the worst case

public class UF_QuickUnion {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	
	// initialize component id array
	public UF_QuickUnion(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
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
		id[i] = j;
		count--;
	}
	
	// solve dynamic connectivity problem on StdIn
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
