/**
 * Runtime: 4136 ms, faster than 5.11% of Kotlin online submissions for Longest Palindromic Substring.
 * Memory Usage: 195.2 MB, less than 5.11% of Kotlin online submissions for Longest Palindromic Substring.
 */
class Solution {
    fun longestPalindrome(s: String): String {
        val size = s.length
        val lastIndex = size - 1
        val queue = LinkedList<Int>()
        val visited = mutableSetOf<Int>()
        for (i in 0 until size) {
            queue.offerLast(i * size + i)
            if (i < lastIndex && s[i] == s[i + 1]) {
                queue.offerLast(i * size + i + 1)
            }
        }
        var resultI = 0
        var resultJ = 0
        while (queue.isNotEmpty()) {
            val point = queue.pollFirst()
            if (point in visited) continue
            
            visited.add(point)
            val i = point / size
            val j = point % size
            if (Math.abs(j - i) > Math.abs(resultJ - resultI)) {
                resultI = i
                resultJ = j
            }
            if (i > 0 && j < lastIndex && s[i - 1] == s[j + 1]) {
                queue.offerLast((i - 1) * size + j + 1)
            }
            if (i < lastIndex && j > 0 && s[i + 1] == s[j - 1]) {
                queue.offerLast((i + 1) * size + j - 1)
            }
        }
        val i = Math.min(resultI, resultJ)
        val j = Math.max(resultI, resultJ)
        return s.substring(i, j + 1)
    }
    
}
