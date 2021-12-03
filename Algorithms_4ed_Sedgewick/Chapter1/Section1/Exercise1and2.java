package chapter0101;

public class Exercise1and2
{
	public static void main(String[] args)
	{
		// 1.1.1
		int a1 = (0 + 15) / 2;
		double b1 = 2.0e-6 * 100000000.1;
		boolean c1 = true && false || true && true;
		System.out.println("1.1.1:");
		System.out.printf("a. ( 0 + 15 ) / 2 -> %d\n", a1);
		System.out.printf("b. 2.0e-6 * 100000000.1 -> %.2f\n", b1);
		System.out.printf("c. true && false || true && true -> %s\n", c1);
		System.out.println();
		
		// 1.1.2
		double a2 = (1 + 2.236) / 2;
		double b2 = 1 + 2 + 3 + 4.0;
		boolean c2 = 4.1 >= 4;
		String d2 = 1 + 2 + "3";
		System.out.println("1.1.2:");
		System.out.printf("a. (1 + 2.236) / 2 -> %.5f\n", a2);
		System.out.printf("b. 1 + 2 + 3 + 4.0 -> %.2f\n", b2);
		System.out.printf("c. 4.1 >= 4 -> %s\n", c2);
		System.out.printf("d. 1 + 2 + " + "\"3\"" + " -> %s\n", d2);
	}

}