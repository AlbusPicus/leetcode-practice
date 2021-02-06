/**
 * Runtime: 176 ms, faster than 97.10% of Kotlin online submissions for Valid Palindrome.
 * Memory Usage: 35.4 MB, less than 95.02% of Kotlin online submissions for Valid Palindrome.
 */
class Solution {
    fun isPalindrome(s: String): Boolean {
        var leftIndex = 0
        var rightIndex = s.length - 1
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !isAlphabetical(s[leftIndex]) && !isNumerical(s[leftIndex])) {
                leftIndex++
            }
            while (leftIndex < rightIndex && !isAlphabetical(s[rightIndex]) && !isNumerical(s[rightIndex])) {
                rightIndex--
            }
            if (s[leftIndex].toLowerCase() == s[rightIndex].toLowerCase()) {
                leftIndex++
                rightIndex--
            } else {
                return false
            }
        }
        return true
    }
    
    private fun isAlphabetical(char: Char): Boolean {
        return (char >= 'A' && char <= 'Z') || (char >= 'a' && char <= 'z')
    }
    
    private fun isNumerical(char: Char): Boolean {
        return char >= '0' && char <= '9'
    }
}
