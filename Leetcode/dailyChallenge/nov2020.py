# 252. Meeting Rooms I *

# Given an array of meeting time intervals where intervals[i] = [starti, endi], 
# determine if a person could attend all meetings.

def canAttendMeetings(intervals):
    """
    :type intervals: List[List[int]]
    :rtype: bool
    """
    result = True
    if len(intervals) == 0:
        return result
    time = [False] * (10**6+1)
    for i in intervals:
        start = i[0]
        end = i[1]
        for j in range(start, end):
            if time[j] == True:
                return False
            else:
                time[j] = True
    return result

# Method: Brute Force
# Time: O(n^2)
# Space: O(1)

# -----

# 1290. Convert Binary Number in a Linked List *

def getDecimalValue(head):
    """
    :type head: ListNode
    :rtype: int
    """
    
    # Two methods:
    
    # decimal operation
    def binaryRepresentation(head):
        num = head.val
        while head.next:
            num = num * 2 + head.next.val
            head = head.next
        return num

    # binary operation
    # example: 1 -> 0 -> 1
    def binaryManipulation(head):
        num = head.val
        while head.next:
            # 1) num = 1; num = (1 << 1) | 0 = (1 0) | (0 0) = (1 0) = 2
            # 2) num = 2; num = (2 << 1) | 1 = (1 0 0) | (0 0 1) = (1 0 1) = 5
            num = (num << 1) | head.next.val
            head = head.next
        return num

    return binaryManipulation(head)

# Method: Bit Operation
# Time: O(n)
# Space: O(1)

# -----

# 1446. Consecutive Characters

# Given a string s, the power of the string is the maximum length of a non-empty substring that 
# contains only one unique character.

# Return the power of the string.

def maxPower(s):
    """
    :type s: str
    :rtype: int
    """
    n = len(s)
    result = count = 0
    slow = fast = 0
    while fast < n:
        if s[slow] == s[fast]:
            fast += 1
            count += 1
        else:
            slow = fast
            count = 0
        result = max(result, count)
    return result

# Method: Two Pointers
# Time: O(N)
# Space: O(1)

# -----
