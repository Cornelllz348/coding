package leetcode;

public class P0061_Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        k = k % length;
        if (k == 0) return head;
        
        ListNode p = head, q = head;
        for (int i = 0; i < k; i++) q = q.next;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode newHead = p.next;
        q.next = head;
        p.next = null;
        return newHead;
    }
}
