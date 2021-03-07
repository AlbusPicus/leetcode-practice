# Runtime: 196 ms, faster than 66.81% of Python3 online submissions for Reverse String.
# Memory Usage: 18.6 MB, less than 57.88% of Python3 online submissions for Reverse String.
class Solution:
    def reverseString(self, s: List[str]) -> None:
        lastIndex = len(s) - 1
        if lastIndex <= 0: return
        
        for i in range(0, int(lastIndex / 2) + 1):
            temp = s[i]
            s[i] = s[lastIndex - i]
            s[lastIndex - i] = temp
        
