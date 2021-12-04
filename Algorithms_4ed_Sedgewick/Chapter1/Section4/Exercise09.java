package chapter0104;

public class Exercise09 {
	
//	give a formula to predict the running time of a program for a problem of size n
//	when doubling experiments have shown that the doubling factor is 2^b and the running time for
//	problems of size n_0 is t.
//
//	we have:
//		t(n0) = t
//		t(2 * n0) = t * 2^b
//		t(4 * n0) = t * 2^b * 2^b
//		t(8 * n0) = t * 2^b * 2^b * 2^b
//		t(16 * n0) = t * 2^b * 2^b * 2^b * 2^b
//		t(n / n0 * n0) = t * (2^b)^(log(n / n0))
//
//	therefore:
//		t(n) = t * (n / n0)^b

}
