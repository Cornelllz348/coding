# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        p1 = l1
        p2 = l2
        l3 = ListNode(0)
        dummy = l3
        while p1 and p2:
            if p1.val > p2.val:
                dummy.next = p2
                p2 = p2.next
            else:
                dummy.next = p1
                p1 = p1.next
            dummy = dummy.next
        dummy.next = p1 if p1 is not None else p2
        return l3.next