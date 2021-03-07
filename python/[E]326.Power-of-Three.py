# Runtime: 56 ms, faster than 98.99% of Python3 online submissions for Power of Three.
# Memory Usage: 14 MB, less than 92.09% of Python3 online submissions for Power of Three.
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n <= 0: return False
        while n % 3 == 0:
            n /= 3
        return n == 1
        
