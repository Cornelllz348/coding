package leetcode;

public class P0019_Remove_nth_Node_from_End_of_List {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = dummy;
        int i = n;
        while (i > 0) {
        	curr = curr.next;
        	i--;
        }
        while (curr.next != null) {
        	curr = curr.next;
        	prev = prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}