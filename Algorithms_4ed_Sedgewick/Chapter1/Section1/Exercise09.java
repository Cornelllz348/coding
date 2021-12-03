package chapter0101;

public class Exercise09
{
	public static void main(String[] args)
	{
		int n = 265;
		String result = convert(n);
		System.out.printf("binary representation of %d is %s\n", n, result);
	}
	
	public static String convert(int n) 
	{
		String s = "";
		for (int k = n; k > 0; k /= 2) {
			s = (k % 2) + s;
		}
		return s;
	}
}