package leetcode;

// You are given two non-empty linked lists representing two non-negative integers. 
// The digits are stored in reverse order, and each of their nodes contains a single digit. 
// Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// public class ListNode {
// 		int val;
// 		ListNode next;
// 		ListNode() {}
// 		ListNode(int val) { this.val = val; }
// 		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }

public class P0002_Add_Two_Numbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode c = l;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        while (c1 != null || c2 != null) {
        	int x = (c1 == null) ? 0 : c1.val;
        	int y = (c2 == null) ? 0 : c2.val;
        	int sum = x + y + carry;
        	int p = sum % 10;
        	carry = (x + y + carry) / 10;
        	c.next = new ListNode(p);
        	c = c.next;
        	if (c1 != null) c1 = c1.next;
        	if (c2 != null) c2 = c2.next;
        }
        if (carry > 0) {
        	c.next = new ListNode(carry);
        }
        return l.next;
    }
}