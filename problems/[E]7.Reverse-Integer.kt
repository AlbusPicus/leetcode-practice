/**
 * Runtime: 140 ms, faster than 74.49% of Kotlin online submissions for Reverse Integer.
 * Memory Usage: 33.4 MB, less than 61.13% of Kotlin online submissions for Reverse Integer.
 */
class Solution {
    fun reverse(x: Int): Int {
        var temp = Math.abs(x)
        var result = 0
        while (temp > 0) {
            val lastDigit = temp % 10
            temp = temp / 10
            
            if (result > MAX_INTEGER_DIVIDED_BY_TEN) return 0
            if (result == MAX_INTEGER_DIVIDED_BY_TEN && lastDigit > 7) return 0
            
            result = result * 10 + lastDigit
        }
        return if (x < 0) -result else result
    }
    
    companion object {
        private const val MAX_INTEGER_DIVIDED_BY_TEN = Int.MAX_VALUE / 10
    }
    
}
