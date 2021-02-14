# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(-1)
        dummy.next = head
        prev = dummy
        
        while head and head.next:
            # nodes to be swapped
            first = head
            second = head.next
            # swap
            prev.next = second
            first.next = second.next
            second.next = first
            # reinitialize the head and prev node for next swap
            prev = first
            head = first.next
            
        return dummy.next
    
    def swapPairsRecursive(self, head):
        # base case: if the list has no node or only one node left
        if not head or not head.next:
            return head
        
        # node to be swaped
        first = head
        second = head.next
        
        # recursive rule: the first node point to the swapped pair
        # the second node point to the first node
        first.next = self.swapPairsRecursive(second.next)
        second.next = first
        
        return second