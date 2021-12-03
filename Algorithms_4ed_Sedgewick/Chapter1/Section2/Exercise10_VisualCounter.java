package chapter0102;

import edu.princeton.cs.algs4.StdOut;

public class Exercise10_VisualCounter {
	
	private final int n;
	private int max;
	private int count;
	private int ops;
	
	public Exercise10_VisualCounter(int n, int max) {
		this.n = n;
		this.max = 0;
		this.count = 0;
		this.ops = 0;
	}
	
	public void increment() {
		if (++ops <= n) {
			count++;
			if (count > max) {
				max = count;
			}
			StdOut.printf("count = %d, max = %d, ops = %d\n", count, max, ops);
		} else {
			StdOut.println("maximum number of operations exceeded");
		}
	}
	
	public void decrement() {
		if (++ops <= n) {
			count--;
			StdOut.printf("count = %d, max = %d, ops = %d\n", count, max, ops);
		} else {
			StdOut.println("maximum number of operations exceeded");
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int max = 0;
		Exercise10_VisualCounter vc = new Exercise10_VisualCounter(n, max);
		vc.increment();
		vc.increment();
		vc.decrement();
		vc.decrement();
		vc.decrement();
		vc.increment();
	}
}
