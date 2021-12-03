package chapter0103;

import edu.princeton.cs.algs4.*;

public class Exercise01

{
	private String[] a; // stack entries
	private int n;      // size
	
	// constructor
	public Exercise01(int capacity) {
		a = new String[capacity];
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}

	public void push(String item) {
		a[n++] = item;
	}

	public String pop() {
		return a[--n];
	}
	
	// exercise 1: add a method isFull() to FixedCapacityStackOfStrings
	public boolean isFull() {
		return a.length == n;
	}
	
	public static void main(String[] args) {
		Exercise01 s;
		s = new Exercise01(100);
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			// if it's not a "-" and the stack is not full, push a string into stack
			if (!item.equals("-") && !s.isFull()) {
				s.push(item);
			} else if (!s.isEmpty()) { // if it's a "-" and the stack is not empty, pop from the stack and print
				StdOut.print(s.pop() + " ");
			}
		}
		// print out the remaining stack
		StdOut.println("(" + s.size() + " left on stack");
	}
	
}