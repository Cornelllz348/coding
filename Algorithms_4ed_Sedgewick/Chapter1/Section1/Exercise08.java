package chapter0101;

//a. b
//System.out.println('b') -> print out a single char b
//
//b. 197
//System.out.println('b' + 'c') -> print out the sum of the Unicode value of the char 'b' and 'c'
//(Binary arithmetic operation on char promoted to int)
//
//c. e
//System.out.println((char) ('a' + 4)) -> print out the sum of the Unicode value of 'a' with 4, converted to char

public class Exercise08
{
	public static void main(String[] args)
	{
		System.out.println('b');
		System.out.println('b' + 'c');
		System.out.println((char) ('a' + 4));
	}
}