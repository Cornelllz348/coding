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
        # Leetcode solution: not reversing the lists
        
        # 1. obtain length of l1 and l2
        n1 = n2 = 0
        curr1, curr2 = l1, l2
        while curr1:
            curr1 = curr1.next 
            n1 += 1
        while curr2:
            curr2 = curr2.next 
            n2 += 1
        
        # 2. sum corresponding positions without taking carry into account
        curr1, curr2 = l1, l2
        head = None
        while n1 > 0 and n2 > 0:
            val = 0
            if n1 >= n2:
                val += curr1.val
                curr1 = curr1.next
                n1 -= 1
            if n1 < n2:
                val += curr2.val
                curr2 = curr2.next
                n2 -= 1
            curr = ListNode(val)
            curr.next = head
            head = curr
        
        # 3. consider carry
        curr1, head = head, None
        carry = 0
        while curr1:
            carry, val = divmod(curr1.val + carry, 10)
            curr = ListNode(val)
            curr.next = head
            head = curr
            curr1 = curr1.next
            
        if carry:
            curr = ListNode(carry)
            curr.next = head
            head = curr
            
        return head