/**
 * Runtime: 2284 ms, faster than 33.82% of Kotlin online submissions for Divide Two Integers.
 * Memory Usage: 33.5 MB, less than 45.59% of Kotlin online submissions for Divide Two Integers.
 */
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val sameSign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)
        var absDividend = -Math.abs(dividend)
        var absDivisor = -Math.abs(divisor)
        
        var result = 0
        while (absDividend <= absDivisor) {
            if (result == Int.MAX_VALUE) {
                return if (sameSign) Int.MAX_VALUE else Int.MIN_VALUE
            }
            result++
            absDividend -= absDivisor
        }
        return if (sameSign) result else -result
    }
}
