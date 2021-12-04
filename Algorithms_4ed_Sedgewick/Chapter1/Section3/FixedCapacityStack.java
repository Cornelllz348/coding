package chapter0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Page 133
// An ADT for a fixed capacity stack of GENERIC ITEMS

public class FixedCapacityStack<Item> { // declare the class with type parameter <Item>
	private Item[] a;		// stack entries
	private int n;			// size
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int capacity) {
		a = (Item[]) new Object[capacity]; // generic array creation is disallowed in java, instead a cast is needed
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public void push(Item item) {
		a[n] = item;
		n++;
	}
	
	public Item pop() {
		n--;
		return a[n];
	}
	
	// test client
	public static void main(String[] args) {
		FixedCapacityStack<String> s; // String is type parameter in test client
		s = new FixedCapacityStack<String>(100);
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
				StdOut.print(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

}
