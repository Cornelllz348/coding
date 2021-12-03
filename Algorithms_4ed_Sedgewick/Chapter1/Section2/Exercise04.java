package chapter0102;

public class Exercise04

{
	public static void main(String[] args) {
		String string1 = "Hello";
		String string2 = string1; // string2 = "Hello"
		string1 = "world"; // string1 = "world"
		StdOut.println(string1);
		StdOut.println(string2);
	}
}