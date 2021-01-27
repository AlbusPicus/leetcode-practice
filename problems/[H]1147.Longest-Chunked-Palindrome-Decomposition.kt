/**
 * Runtime: 128 ms, faster than 75.00% of Kotlin online submissions for Longest Chunked Palindrome Decomposition.
 * Memory Usage: 33.5 MB, less than 75.00% of Kotlin online submissions for Longest Chunked Palindrome Decomposition.
 */
class Solution {
    fun longestDecomposition(text: String): Int {
        var leftHash = 0L
        var rightHash = 0L

        var mod = Int.MAX_VALUE.toLong()
        var rightMultiplier = 1L

        var left = 0
        var right = text.length - 1
        var count = 0
        while (left < right) {            
            leftHash *= HASH_MULTIPLIER
            leftHash += text.get(left) - FIRST_ALPHABET_CHAR
            leftHash %= mod

            rightHash += (text.get(right) - FIRST_ALPHABET_CHAR) * rightMultiplier
            rightHash %= mod

            rightMultiplier *= HASH_MULTIPLIER
            rightMultiplier %= mod

            if (leftHash == rightHash) {
                count += 2

                leftHash = 0
                rightHash = 0
                rightMultiplier = 1
            }

            left++
            right--
        }

        if (leftHash != 0L || left == right || count == 0) {
            count++
        }

        return count
    }
    
    companion object {
        const val FIRST_ALPHABET_CHAR = 'a'
        const val HASH_MULTIPLIER = 26
    }
}
