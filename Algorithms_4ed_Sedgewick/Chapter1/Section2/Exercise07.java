package chapter0102;

import edu.princeton.cs.algs4.*;

// recursive method to revert the string

public class Exercise07

{
	public static void main(String[] args) {
		StdOut.println(mystery("abcdefgh"));
	}
	
	public static String mystery(String s) {
		int n = s.length();
		if (n <= 1) {
			return s;
		}
		String a = s.substring(0, n/2);
		String b = s.substring(n/2, n);
		return mystery(b) + mystery(a);
	}
	
//	                                              abcdefgh
//	                                    /                       \
//	                                 efgh                      abcd
//	                              /     \                    /       \
//	                             gh       ef               cd        ab
//	                           /   \     /   \            /   \     /   \
//	                          h     g   f    e           d     c   b     a
	
}