class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        if num1 == '0' or num2 == '0':
            return '0'
        l1 = len(num1)
        l2 = len(num2)
        products = [[0] * (l1 + l2) for _ in range(l2)]
        for i in range(l2):
            carry = 0
            j = 0
            n1 = int(num2[-1-i])
            for j in range(l1):
                n2 = int(num1[-1-j])
                products[i][-1 - i - j] = carry + (n1 * n2) % 10
                carry = (n1 * n2) // 10
            if carry:
                products[i][-1 - i - l1] += carry
        result = [0] * (l1 + l2)
        carry = 0
        for i in range(len(products[0])):
            tmp = 0
            for j in range(len(products)):
                tmp += products[j][-1-i]
            result[-1 - i] += (tmp + carry) % 10
            carry = (tmp + carry) // 10
        string = ''
        if result[0] == 0:
            string = ''.join(map(str, result[1:]))
        else:
            string = ''.join(map(str, result))
        return string