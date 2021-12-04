package chapter0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// the code will output "was best times of the was the it"

public class Exercise02 {
	
	public static void main(String[] args) {
		
		FixedCapacityStack<String> s; // String is type parameter in test client
		
		s = new FixedCapacityStack<String>(100);
		
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