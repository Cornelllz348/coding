package chapter0102;

import edu.princeton.cs.algs4.*;

// detect if one string is a circular shift of the other

public class Exercise06
{	
	public static void main(String[] args) {
		String s1 = "ACTGACG";
		String s2 = "TGACGAC";
		StdOut.print(isCircularShift(s1, s2));
	}
	
	// if the two strings are of the same length and s2 can be found in the concatenated string,
	// then the two strings are circular shift of each other
	public static boolean isCircularShift(String s1, String s2) {
		String s = s1 + s1;
		return (s1.length() == s2.length() && s.indexOf(s2) > -1);
	}
}