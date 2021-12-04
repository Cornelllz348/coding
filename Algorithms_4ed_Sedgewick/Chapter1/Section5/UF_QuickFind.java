package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// 1. Quick Find implementation of Union Find
// maintain the invariant that p and q are connected iff id[p] == id[q]
// i.e. all sites in a component must have the same value in id[]
// it will not work for large problems because union() needs to scan through
// the whole id[] array for each input pair

public class UF_QuickFind {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	
	// initialize component id array
	public UF_QuickFind(int n) {
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
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		// do nothing if p and q already connected
		if (pID == qID) {
			return;
		}
		// change values from id[p] to id[q]
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;
	}
	
	// solve dynamic connectivity problem on StdIn
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
