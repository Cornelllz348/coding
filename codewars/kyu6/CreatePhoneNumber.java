package kyu6;
import java.util.*;

public class CreatePhoneNumber {
	public static String createPhoneNumber(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(Integer.toString(numbers[0]));
		sb.append(Integer.toString(numbers[1]));
		sb.append(Integer.toString(numbers[2]));
		sb.append(") ");
		sb.append(Integer.toString(numbers[3]));
		sb.append(Integer.toString(numbers[4]));
		sb.append(Integer.toString(numbers[5]));
		sb.append("-");
		sb.append(Integer.toString(numbers[6]));
		sb.append(Integer.toString(numbers[7]));
		sb.append(Integer.toString(numbers[8]));
		sb.append(Integer.toString(numbers[9]));
		return sb.toString();
	}
}