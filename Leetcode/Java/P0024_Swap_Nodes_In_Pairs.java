package leetcode;

public class P0024_Swap_Nodes_In_Pairs {
	
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode prev = dummy;
    	while (head != null && head.next != null) {
    		// assign first and second node
            ListNode first = head;
            ListNode second = head.next;
            // swap order
            prev.next = second;
            first.next = second.next;
            second.next = first;
            // re-assign prev and head node
            prev = first;
            head = first.next;
    	}
    	return dummy.next;
    }
}

//			 head
//  dummy ->  1  ->  2  ->  3  ->  4  ->  5  ->  null
//   prev   first  second

//Swap order:
//1. prev.next = second
//2. first.next = second.next
//3. second.next = first

//	       		
//  dummy ->  2  ->  1  ->  3  ->  4  ->  5  ->  null
//   	   second  first
//				    prev  head