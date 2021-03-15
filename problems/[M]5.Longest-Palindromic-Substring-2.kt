/**
 * Runtime: 176 ms, faster than 99.56% of Kotlin online submissions for Longest Palindromic Substring.
 * Memory Usage: 35.7 MB, less than 92.22% of Kotlin online submissions for Longest Palindromic Substring.
 */
class Solution {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        var start = 0
        var end = 0
        for (i in 0 until s.length) {
            val expandOnOne = expandAroundCentre(s, i, i)
            val expandOnTwo = expandAroundCentre(s, i, i + 1)
            val length = Math.max(expandOnOne, expandOnTwo)
            if (length > end - start) {
                start = i - (length - 1) / 2
                end = i + length / 2
            }
        }
        return s.substring(start, end + 1)
    }
    
    private fun expandAroundCentre(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right
        while (L >= 0 && R < s.length && s[L] == s[R]) {
            L--
            R++
        }
        return R - L - 1
    }
    
}
