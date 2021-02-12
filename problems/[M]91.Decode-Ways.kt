/**
 * Runtime: 144 ms, faster than 92.75% of Kotlin online submissions for Decode Ways.
 * Memory Usage: 35.5 MB, less than 28.02% of Kotlin online submissions for Decode Ways.
 */
class Solution {
    fun numDecodings(s: String): Int {
        val memo = mutableMapOf<Int, Int>()
        memo.put(s.length, 1)
        memo.put(s.lastIndex, if (s.get(s.lastIndex) > '0') 1 else 0)
        return numberOfDecodings(s, 0, memo)
    }
    
    private fun numberOfDecodings(encoded: String, startIndex: Int, memo: MutableMap<Int, Int>): Int {
        val savedValue = memo.get(startIndex)
        if (savedValue != null) return savedValue
        
        
        val char = encoded.get(startIndex)
        
        val result = when (char) {
            '0' -> 0
            '1' -> numberOfDecodings(encoded, startIndex + 1, memo) + numberOfDecodings(encoded, startIndex + 2, memo)
            '2' -> if (startIndex < encoded.lastIndex && encoded.get(startIndex + 1) <= '6') {
                numberOfDecodings(encoded, startIndex + 1, memo) + numberOfDecodings(encoded, startIndex + 2, memo)
            } else numberOfDecodings(encoded, startIndex + 1, memo)
            else -> numberOfDecodings(encoded, startIndex + 1, memo)
        }
        memo.put(startIndex, result)
        return result
    }
}
