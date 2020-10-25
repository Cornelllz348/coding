# 21. Merge Two Sorted Lists *

# Merge two sorted linked lists and return it as a new sorted list. 
# The new list should be made by splicing together the nodes of the first two lists.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
def mergeTwoLists(l1, l2):
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
        # move whichever is smaller
        if p1.val > p2.val:
            dummy.next = p2
            p2 = p2.next
        else:
            dummy.next = p1
            p1 = p1.next
        dummy = dummy.next
    dummy.next = p1 if p1 is not None else p2
    return l3.next

# Method: Linked List
# Time: O(L1 + L2) where L1 and L2 are the length of linked list 1 and 2
# Space: O(L1 + L2)

# -----

# 22. Generate Parentheses **

# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

# Input: n = 3
# Output: ["((()))","(()())","(())()","()(())","()()()"]

def generateParentheses(n):
    ans = []
    def backtrack(S = "", left = 0, right = 0):
        # Let S is string where number of "(" is >= number of ")"
        # Let left track the number of "(" and right track the number of ")"
        # if len(S) is 2*n, stop running as all parentheses have been used up
        if len(S) == 2*n:
            ans.append(S)
            return
        # 1. add "(" if there is still "(" left
        if left < n:
            backtrack(S + "(", left+1, right)
        # 2. add ")" only if the number of "(" is greater than the number of ")"
        if right < left:
            backtrack(S + ")", left, right+1)

    backtrack("", 0, 0)
    return ans

# Method: String, Backtracking
# Time: O(1/(n+1) * C(n, 2n)) - the n-th Catalan number
# Space: O(1/(n+1) * C(n, 2n))

"""
n-th Catalan number:
* given a list of 1 and -1, such that the sum of any leading sub-array is non-negative
* step 1: without considering order of 1 and -1, we have a total of C(n, 2n) combinations
* step 2: this includes C(n-1, 2n) ILLEGAL orders; each ILLEGAL order corresponds to an order of n+1
          1's and n-1 -1's
* step 3: C(n, 2n) - C(n-1, 2n) = 1/(n+1) * C(n,2n)

"""

# -----

# 23. Merge k Sorted Lists ***

# You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
# Merge all the linked-lists into one sorted linked-list and return it.

def mergeKLists(lists):
    """
    :type lists: List[ListNode]
    :rtype: ListNode
    """
    amount = len(lists)
    interval = 1
    while interval < amount:
        for i in range(0, amount - interval, interval * 2):
            lists[i] = merge2Lists(lists[i], lists[i + interval])
        interval = interval * 2
    return lists[0] if amount > 0 else None

def merge2Lists(l1, l2):
    head = point = ListNode(0)
    while l1 and l2:
        if l1.val <= l2.val:
            point.next = l1
            l1 = l1.next
        else:
            point.next = l2
            l2 = l2.next
        point = point.next
    if not l1:
        point.next = l2
    else:
        point.next = l1
    return head.next

# Method: Divide and Conquer
# Time: O(NlogK) where K is the number of linked lists and N is the upper bound of total number of nodes of two linked lists
# Space: O(1)

# -----

# 24. Swap Nodes in Pairs **

# Given a linked list, swap every two adjacent nodes and return its head.
# You may not modify the values in the list's nodes. Only nodes itself may be changed.

# Example: 1 (head) -> 2 -> 3 -> 4

def swapPairs(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    # -1 (dummy) -> 1 -> 2 -> 3 -> 4
    dummy = ListNode(-1)
    dummy.next = head
    # -1 (prev) -> 1 -> 2 -> 3 -> 4
    prev = dummy

    while head and head.next:
        # nodes to be swapped
        first = head # 1 (first) -> 2 -> 3 -> 4
        second = head.next # 2 (second) -> 3 -> 4
        # swap
        prev.next = second # -1 (prev) -> 2 (prev.next = second) -> 3 -> 4
        first.next = second.next # 1 (first) -> 3 (first.next = second.next) -> 4
        second.next = first # 2 (second) -> 1 (second.next = first) -> 3 -> 4
        # reinitialize the head and prev node for next swap
        prev = first # 2 -> 1 (prev = first) -> 3 -> 4
        head = first.next # 2 -> 1 (prev = first) -> 3 (head = first.next) -> 4

    return dummy.next # -1 (dummy) -> 2 -> 1 -> 4 -> 3

# Method: Linked List
# Time: O(n)
# Space: O(1)

# -----

# 25. Reverse Nodes in k-Group ***

# Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
# k is a positive integer and is less than or equal to the length of the linked list.
# If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

def reverseKGroup(self, head, k):
    """
    :type head: ListNode
    :type k: int
    :rtype: ListNode
    """
    count = 0
    ptr = head

    # reverse every k nodes in the linked list, so ptr makes jump of size k
    while count < k and ptr:
        ptr = ptr.next
        count += 1

    if count == k:
        # reverse first k nodes of the linked list and return head of the reversed linked list
        reversedHead = self.reverseLinkedList(head, k)
        # recurse on the remaining nodes
        # let the original head point to the reversed head which is returned by the recursion
        head.next = self.reverseKGroup(ptr, k)
        return reversedHead

    return head

# this function reverse the first k nodes of a given linked list (head)
def reverseLinkedList(self, head, k):

    new_head, ptr = None, head

    while k:
        # keep track of the next node to process in the original linked list
        next_node = ptr.next
        # insert the node pointed to by "ptr" at the beginning of the reversed list
        ptr.next = new_head
        new_head = ptr
        # move on to the next node
        ptr = next_node
        k -= 1

    return new_head

# Method: Linked List
# Time: O(N)
# Space: O(N/k)

# -----

# 26. Remove Duplicates from Sorted Array *

# Given a sorted array nums, remove the duplicates in-place such that each element appears only once
# and returns the new length.
# Do not allocate extra space for another array, you must do this by modifying the input array in-place 
# with O(1) extra memory.

def removeDuplicates(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    x = 1
    for i in range(len(nums)-1):
        if(nums[i] != nums[i+1]):
            nums[x] = nums[i+1]
            x = x + 1
    return x
    
# -----

# 27. Remove Element *

# Given an array nums and a value val, remove all instances of that value in-place and return the new length.
# Do not allocate extra space for another array, you must do this by modifying the input array in-place
# with O(1) extra memory.
# The order of elements can be changed. It doesn't matter what you leave beyond the new length.

def removeElement(nums, val):
    i = 0
    for j in range(len(nums)):
        if nums[j] != val:
            nums[i] = nums[j]
            i = i + 1
    return i
    
# -----

# 28. Implement strStr() *

# Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
# What should we return when needle is an empty string? This is a great question to ask during an interview.
# For the purpose of this problem, we will return 0 when needle is an empty string. 
# This is consistent to C's strstr() and Java's indexOf().

def strStr(haystack, needle):
    """
    :type haystack: str
    :type needle: str
    :rtype: int
    """
    if needle == "":
        return 0
    if len(needle) > len(haystack):
        return -1
    for i in range(len(haystack) - len(needle) + 1):
        if haystack[i:i+len(needle)] == needle:
            return i
    return -1
    
# -----

# 29. Divide Two Integers **

# Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
# Return the quotient after dividing dividend by divisor.
# The integer division should truncate toward zero, which means losing its fractional part. 
# For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

def divide(self, dividend, divisor):
    """
    :type dividend: int
    :type divisor: int
    :rtype: int
    """
    max_int = 2147483647
    min_int = -2147483648
    half_min_int = -1073741824

    if dividend == min_int and divisor == -1:
        return max_int

    # convert both numbers to negatives to avoid overflow
    # negative = 1 means only one of the numbers is negative
    negatives = 2
    if dividend > 0:
        negatives -= 1
        dividend = -dividend
    if divisor > 0:
        negatives -= 1
        divisor = -divisor

    quotient = 0

    # both numbers are now negative here
    # if divisor < dividend (i.e. divisor is numerically larger than dividend),
    # we cannot fit any more copies of the divisor into dividend
    while divisor >= dividend:
        # powerOfTwo keeps track of the number of copies of the divisor in current iteration 
        powerOfTwo = -1
        value = divisor
        # fit copies of the divisor into dividend
        while value >= half_min_int and value + value >= dividend:
            value += value
            powerOfTwo += powerOfTwo
        quotient += powerOfTwo
        dividend -= value

    return -quotient if negatives != 1 else quotient

# Method: Exponential Search
# Time: O(logN * logN)
# Space: O(1)

# -----
