/**
 * Runtime: 164 ms, faster than 100.00% of Kotlin online submissions for Unique Substrings in Wraparound String.
 * Memory Usage: 35.9 MB, less than 100.00% of Kotlin online submissions for Unique Substrings in Wraparound String.
 */
class Solution {
    fun findSubstringInWraproundString(p: String): Int {
        if (p.length == 0) return 0
        
        val maxSubStringLengths = IntArray(26) { 0 }
        
        val startIndex = 'a'.toInt()
        val ZCharIndex = 'z'.toInt() - startIndex
        var lastIndex = -2
        var sequenceSize = 0
        p.forEach { char ->
            val charIndex = char.toInt() - startIndex
            if ((charIndex == lastIndex + 1) || (ZCharIndex == lastIndex && charIndex == 0)) {
                sequenceSize++
            } else {
                sequenceSize = 1
            }
            lastIndex = charIndex
            maxSubStringLengths[charIndex] = Math.max(maxSubStringLengths[charIndex], sequenceSize)
        }
        var result = 0
        maxSubStringLengths.forEach { length -> 
            result += length
        }
        return result
    }
}
