/**
 * Runtime: 160 ms, faster than 83.94% of Kotlin online submissions for Implement strStr().
 * Memory Usage: 35.7 MB, less than 61.66% of Kotlin online submissions for Implement strStr().
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val haystackSize = haystack.length
        val needleSize = needle.length
        if (needleSize == 0) return 0
        
        haystack.forEachIndexed { index, char ->
            if (char == needle.get(0) && haystackSize >= needleSize + index) {
                var found = true
                for (i in 0 until needleSize) {
                    if (haystack.get(index + i) != needle.get(i)) {
                        found = false
                        break
                    }
                }
                if (found) {
                    return index
                }
            }
        }
        return -1
    }
}
