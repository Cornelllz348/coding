package kyu6;

import java.util.*;

public class MultiplesOf3Or5 {

  public static int solution(int number) {
    int sum = 0;
    for (int i = 0; i < number; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }
  
  public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
	  int number = s.nextInt();
	  System.out.println(solution(number));
  }
}