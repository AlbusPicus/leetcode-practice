/**
 * Runtime: 300 ms, faster than 33.04% of Kotlin online submissions for Minimum Window Substring.
 * Memory Usage: 40.1 MB, less than 45.22% of Kotlin online submissions for Minimum Window Substring.
 */
class Solution {
    fun minWindow(s: String, t: String): String {
        val charsInT = mutableMapOf<Char, Int>()
        t.forEach { char ->
            charsInT[char] = charsInT.getOrDefault(char, 0) + 1
        }
        val currentState = mutableMapOf<Char, Int>()
        var resultStart = 0
        var resultEnd = s.length + 1
        var left = 0
        var right = 0
        while (right < s.length) {
            if (left < right && areAtLeast(charsInT, currentState)) {
                if (resultEnd - resultStart > right - left) {
                    resultStart = left
                    resultEnd = right
                }
                val char = s[left]
                currentState[char] = currentState[char]!! - 1
                left++
            } else {
                val char = s[right]
                currentState[char] = currentState.getOrDefault(char, 0) + 1
                right++
            }
        }
        
        while (areAtLeast(charsInT, currentState)) {
            if (resultEnd - resultStart > right - left) {
                resultStart = left
                resultEnd = right
            }
            val char = s[left]
            
            currentState[char] = currentState.getOrDefault(char, 0) - 1
            left++
        }
        return if (resultEnd > s.length) "" else s.substring(resultStart, resultEnd)
    }
    
    private fun areAtLeast(minimum: Map<Char, Int>, possible: Map<Char, Int>): Boolean {
        minimum.entries.forEach { entry ->
            if (possible.getOrDefault(entry.key, 0) < entry.value) return false
        }
        return true
    }
}
