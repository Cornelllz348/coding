class Solution(object):
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