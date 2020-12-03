# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        p, q, curr = l1, l2, dummy
        carry = 0
        while p or q:
            a = p.val if p else 0
            b = q.val if q else 0
            val = (a + b + carry) % 10
            curr.next = ListNode(val)
            carry = (a + b + carry) // 10
            curr = curr.next
            if p: p = p.next
            if q: q = q.next
        if carry:
            curr.next = ListNode(carry)
        return dummy.next