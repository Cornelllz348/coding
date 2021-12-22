package chapter0105;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Estimate the min amount of time (in days) that would be required for quick-find to solve a dynamic connectivity problem
// with 10^9 sites and 10^6 input pairs, on a computer capable of executing 10^9 instructions per second.
// Assume that each iteration of the inner for loop requires 10 machine instructions.

// Estimate: 10^10 * 10^6 = 10^16 instructions
// Using 10^16 / 10^9 = 10^7 seconds which is ~115 days

public class Exercise05 {
	private int[] id; // access to component id (site indexed)
	private int count; // number of components
	
	// initialize component id array
	public Exercise05(int n) {
		count = n;								// 1 instruction
		id = new int[n];						// 1 instruction
		for (int i = 0; i < n; i++) {			// 10^10 instructions of for loop = 10^9 for loops * 10 instructions each for loop
			id[i] = i;							// 10^9 instructions to initialize id[] array
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
		return id[p];							// 1 instruction
	}
	
	// add connection between p and q
	public void union(int p, int q) {
		int pID = find(p);						// 1 instruction
		int qID = find(q);						// 1 instruction
		// do nothing if p and q already connected
		if (pID == qID) {
			return;
		}
		// change values from id[p] to id[q]
		for (int i = 0; i < id.length; i++) {	// 10^10 instructions
			if (id[i] == pID) {
				id[i] = qID;
			}
		}
		count--;
	}
	
	public static void main(String[] args) {
		int n = StdIn.readInt();
		Exercise05 uf = new Exercise05(n);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();			// read pair to connect
			if (uf.connected(p, q)) {			// ignore if connected
				continue;
			}
			uf.union(p, q);						// combine components; 10^6 input pairs
			StdOut.println(p + " " + q);		// and print connection
		}
		StdOut.println(uf.count() + " components");
	}
	
}
