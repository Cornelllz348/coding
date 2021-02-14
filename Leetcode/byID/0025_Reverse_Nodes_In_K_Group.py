# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        count = 0
        ptr = head
        
        while count < k and ptr:
            ptr = ptr.next
            count += 1
            
        if count == k:
            reversedHead = self.reverseLinkedList(head, k)
            head.next = self.reverseKGroup(ptr, k)
            return reversedHead
        
        return head
    
    def reverseLinkedList(self, head, k):
        
        new_head, ptr = None, head
        
        while k:
            next = ptr.next
            ptr.next = new_head
            new_head = ptr
            ptr = next
            k -= 1
            
        return new_head