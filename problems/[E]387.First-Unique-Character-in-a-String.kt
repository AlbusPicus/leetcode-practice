/**
 * Runtime: 208 ms, faster than 95.72% of Kotlin online submissions for First Unique Character in a String.
 * Memory Usage: 36.1 MB, less than 91.98% of Kotlin online submissions for First Unique Character in a String.
 */
class Solution {
    fun firstUniqChar(s: String): Int {
        val charsFrequency = IntArray(26)
        s.forEach { char ->
            val charIndex = char - 'a'
            charsFrequency[charIndex] = charsFrequency[charIndex] + 1
        }
        s.forEachIndexed { index, char ->
            val charIndex = char - 'a'
            if (charsFrequency[charIndex] == 1) return index
        }
        return -1
    }
}
