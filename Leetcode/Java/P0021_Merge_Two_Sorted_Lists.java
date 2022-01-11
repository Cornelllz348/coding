package leetcode;

public class P0021_Merge_Two_Sorted_Lists {
	
//	You are given the heads of two sorted linked lists list1 and list2.
//	Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//	Return the head of the merged linked list.
	
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy1 = list1, dummy2 = list2, head = new ListNode(-1), dummy = head;
    	while (dummy1 != null && dummy2 != null) {
    		if (dummy1.val < dummy2.val) {
    			dummy.next = dummy1;
    			dummy1 = dummy1.next;
    		} else {
    			dummy.next = dummy2;
    			dummy2 = dummy2.next;
    		}
    		dummy = dummy.next;
    	}
    	if (dummy1 != null) {
            dummy.next = dummy1;
    	}
    	if (dummy2 != null) {
            dummy.next = dummy2;
    	}
    	return head.next;
    }
}