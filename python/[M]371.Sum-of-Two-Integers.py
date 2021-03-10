# Runtime: 28 ms, faster than 79.33% of Python3 online submissions for Sum of Two Integers.
# Memory Usage: 14 MB, less than 98.26% of Python3 online submissions for Sum of Two Integers.
class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xFFFFFFFF
        MAXVAL = 0x7FFFFFFF
        additionValue = b
        result = a
        while additionValue != 0:
            carry = result & additionValue
            result = (result ^ additionValue) & MASK
            additionValue = (carry << 1) & MASK
            
        if result > MAXVAL:
            result = ~(result ^ MASK)
            
        return result
