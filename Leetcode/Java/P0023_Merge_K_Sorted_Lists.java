package leetcode;

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.
		
public class P0023_Merge_K_Sorted_Lists {
	
	int size;
	int interval;
	
    public ListNode mergeKLists(ListNode[] lists) {
        size = lists.length;
        interval = 1;
        while (interval < size) {
        	for (int i = 0; i < size - interval; i += interval * 2) {
        		lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
        	}
        	interval *= 2;
        }
        return size > 0 ? lists[0] : null;
    }
	
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
