/**
 * Runtime: 168 ms, faster than 82.76% of Kotlin online submissions for Longest Common Prefix.
 * Memory Usage: 35.1 MB, less than 87.59% of Kotlin online submissions for Longest Common Prefix.
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        
        var minLength = Int.MAX_VALUE
        strs.forEach { str ->
            minLength = Math.min(minLength, str.length)
        }
        
        for (i in 0 until minLength) {
            val char = strs[0][i]
            strs.forEach { str ->
                if (str[i] != char) return str.substring(0, i)
            }
        }
        return strs[0].substring(0, minLength)
    }
}
