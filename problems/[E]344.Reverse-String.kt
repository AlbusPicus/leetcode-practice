/**
 * Runtime: 232 ms, faster than 84.96% of Kotlin online submissions for Reverse String.
 * Memory Usage: 48 MB, less than 81.96% of Kotlin online submissions for Reverse String.
 */
class Solution {
    fun reverseString(s: CharArray): Unit {
        val size = s.size
        val lastIndex = s.lastIndex
        for (i in 0 until size / 2) {
            val temp = s[i]
            s[i] = s[lastIndex - i]
            s[lastIndex - i] = temp 
        }
    }
}
