package chapter0103;

public class Exercise03 {
	
//which of the following sequence(s) could not occur:
//	a. 4 3 2 1 0 9 8 7 6 5 (can occur)
//	push 0
//	push 1
//	push 2
//	push 3
//	push 4
//	pop -> 4 (0, 1, 2, 3)
//	pop -> 3 (0, 1, 2)
//	pop -> 2 (0, 1)
//	pop -> 1 (0)
//	pop -> 0 (empty)
//	push 5
//	push 6
//	push 7
//	push 8
//	push 9
//	pop -> 9 (5, 6, 7, 8)
//	pop -> 8 (5, 6, 7)
//	pop -> 7 (5, 6)
//	pop -> 6 (5)
//	pop -> 5 (empty)
//
//	b. 4 6 8 7 5 3 2 9 0 1 (cannot occur)
//
//	c. 2 5 6 7 4 8 9 3 1 0 (can occur)
//	push 0
//	push 1
//	push 2
//	pop -> 2 (0, 1)
//	push 3
//	push 4
//	push 5
//	pop -> 5 (0, 1, 3, 4)
//	push 6
//	pop -> 6 (0, 1, 3, 4)
//	push 7
//	pop -> 7 (0, 1, 3, 4)
//	pop -> 4 (0, 1, 3)
//	push 8
//	pop -> 8 (0, 1, 3)
//	push 9
//	pop -> 9 (0, 1, 3)
//	pop
//	pop
//	pop
//
//	d. 4 3 2 1 0 5 6 7 8 9 (can occur)
//
//	e. 1 2 3 4 5 6 9 8 7 0 (can occur)
//
//	f. 0 4 6 5 3 8 1 7 2 9 (cannot occur)
//	push 0
//	pop -> 0 empty
//	push 1
//	push 2
//	push 3
//	push 4
//	pop -> 4 (1, 2, 3)
//	push 5
//	push 6
//	pop -> 6 (1, 2, 3, 5)
//	pop -> 5 (1, 2, 3)
//	pop -> 3 (1, 2)
//	push 7
//	push 8
//	pop -> 8 (1, 2, 7)
//	pop -> 7 (ERROR)
//
//	g. 1 4 7 9 8 6 5 3 0 2 (cannot occur)
//
//	h. 2 1 4 3 6 5 8 7 9 0 (can occur)

}
