/**
 * Runtime: 584 ms, faster than 5.10% of Kotlin online submissions for Regular Expression Matching.
 * Memory Usage: 41.1 MB, less than 12.25% of Kotlin online submissions for Regular Expression Matching.
 */
class Solution {
    fun isMatch(text: String, pattern: String): Boolean {
        if (pattern.isEmpty()) return text.isEmpty()
        
        val first_match = (text.isNotEmpty() && (pattern[0] == text[0] || pattern[0] == '.'))

        return if (pattern.length >= 2 && pattern[1] == '*') {
            val zeroItems = isMatch(text, pattern.substring(2))
            val firstItem = first_match && isMatch(text.substring(1), pattern)
            zeroItems || firstItem
        } else {
            first_match && isMatch(text.substring(1), pattern.substring(1))
        }
    }
}
