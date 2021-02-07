/**
 * Runtime: 184 ms, faster than 97.13% of Kotlin online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 35.6 MB, less than 91.00% of Kotlin online submissions for Longest Substring Without Repeating Characters.
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastOccuranceIndex = mutableMapOf<Char, Int>()
        var longestSize = 0
        var currentStart = -1
        s.forEachIndexed { index, char ->
            val lastSeenAt = lastOccuranceIndex.getOrElse(char, { -1 })
            if (lastSeenAt > currentStart) {
                longestSize = Math.max(longestSize, index - currentStart - 1)
                currentStart = lastSeenAt
            }
            lastOccuranceIndex.put(char, index)
        }
        longestSize = Math.max(longestSize, s.length - currentStart - 1)
        return longestSize
    }
}
