package chapter0104;

public class Exercise01 {
	
//	1.4.1. show that the number of different triples that can be chosen from n items is precisely n(n-1)(n-2)/6.
//
//	Proof by induction:
//	1) base case: n = 3, number of different triples is 1
//	2) induction: assuming that number of different triples chosen from n items is n(n-1)(n-2)/6
//				  show that number of different triples chosen from (n+1) items is n(n+1)(n-1)/6
//				  n(n+1)(n-1)/6 = n(n-1)(n-2)/6 + n(n-1)/2
//				  where n(n-1)/2 is exactly the number of new triples made available by the new item (i.e. choose 2 from n)

}
