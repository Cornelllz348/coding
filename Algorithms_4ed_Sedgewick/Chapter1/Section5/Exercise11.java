package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// implement weighted quick-find, where you always change the id[] entries of the smaller component to the identifier of 
// the larger component.

public class Exercise11 {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	private int[] sz; // size of component of roots (site indexed)
	
	// initialize component id array
	public Exercise11(int n) {
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
		return id[p];
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
		Exercise11 uf = new Exercise11(n);
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
