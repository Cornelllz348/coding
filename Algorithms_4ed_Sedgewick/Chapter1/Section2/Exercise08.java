package chapter0102;

public class Exercise08 {
	
	// the code snippet swaps array a and b
	
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		int[] t = a;
		a = b;
		b = t;
	}
}
