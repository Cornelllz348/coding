package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise08 {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	
	// initialize component id array
	public Exercise08(int n) {
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
		return id[p];
	}
	
	// add connection between p and q
	// Exercise 07: this implementation of union() for quick-find is not correct
	// Counterexample:
	// p q 0 1 2 3 4 5 6 7 8 9
	// 4 3 0 1 2 3 4 5 6 7 8 9
	//     0 1 2 3 3 5 6 7 8 9
	// 3 8 0 1 2 3 3 5 6 7 8 9
	//     0 1 2 8 8 5 6 7 8 9  -- correct
	//     0 1 2 8 3 5 6 7 8 9  -- incorrect as id[p] has already been changed
	public void union(int p, int q) {
		// do nothing if p and q already connected
		if (id[p] == id[q]) {
			return;
		}
		// change values from id[p] to id[q]
		for (int i = 0; i < id.length; i++) {
			if (id[i] == id[p]) {
				id[i] = id[q];
			}
		}
		count--;
	}
	
	// solve dynamic connectivity problem on StdIn
	public static void main(String[] args) {
		int n = StdIn.readInt();
		Exercise08 uf = new Exercise08(n);
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
