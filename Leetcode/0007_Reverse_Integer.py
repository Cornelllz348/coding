class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        result = 0
        sign = 1
        if x < 0:
            x = -x
            sign = -1
        while x != 0:
            x, b = divmod(x, 10)
            result = result * 10 + b
        if result < - 2**31 or result > 2**31 - 1:
            return 0
        else:
            return result * sign