package chapter0103;

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//it was - the best - of times - - - it was - the - -
//was best times of the was the it (1 left on stack)

public class Exercise08 implements Iterable<String>
{
	private String[] a = new String[1];  	// stack items
	private int n = 0;       // number of items
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	private void resize(int max) {
		// move stack to a new array of size max
		String[] temp = new String[max];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void push(String str) {
		// add string to top of stack
		if (n == a.length) {
			resize(2 * a.length);
		}
		a[n] = str;
		n++;
	}
	
	public String pop() {
		// remove string from top of stack
		n--;
		String str = a[n];
		a[n] = null;				// avoid loitering
		if (n > 0 && n == a.length/4) {
			resize(a.length/2);
		}
		return str;
	}
	
	public Iterator<String> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<String> {
		// supports LIFO iteration
		private int i = n - 1;
		public boolean hasNext() {
			return i >= 0;
		}
		public String next() {
			i--;
			return a[i];
		}
		public void remove() {}
	}
	
	public static void main(String[] args) {
		
		Exercise08 s = new Exercise08();
		
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.push(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.pop() + " ");
			}
		}
		
		StdOut.println("(" + s.size() + " left on stack)");
	}

}