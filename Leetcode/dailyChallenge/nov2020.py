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
