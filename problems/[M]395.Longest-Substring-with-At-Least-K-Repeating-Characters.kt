/**
 * Runtime: 132 ms, faster than 89.29% of Kotlin online submissions for Longest Substring with At Least K Repeating Characters.
 * Memory Usage: 33.3 MB, less than 92.86% of Kotlin online submissions for Longest Substring with At Least K Repeating Characters.
 */
class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        return longestLenght(s, k, 0, s.length)
    }
    
    private fun longestLenght(s: String, k: Int, start: Int, end: Int): Int {
        if (end - start < k) return 0
        
        val charsFrequency = IntArray(26)
        for (i in start until end) {
             val index = s[i].toInt() - 'a'.toInt()
            charsFrequency[index] = charsFrequency[index] + 1
        }
        
        for (mid in start until end) {
            if (charsFrequency[s[mid].toInt() - 'a'.toInt()] < k) {
                var nextStart = mid + 1
                while (nextStart < end && charsFrequency[s[nextStart].toInt() - 'a'.toInt()] < k) {
                    nextStart++
                }
                return Math.max(longestLenght(s, k, start, mid), longestLenght(s, k, nextStart, end))
            }
        }
        
        return end - start
    }
    
}
