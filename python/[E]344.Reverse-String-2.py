# Runtime: 196 ms, faster than 66.81% of Python3 online submissions for Reverse String.
# Memory Usage: 18.6 MB, less than 57.88% of Python3 online submissions for Reverse String.
class Solution:
    def reverseString(self, s: List[str]) -> None:
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left, right = left + 1, right - 1
        
