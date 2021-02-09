/**
 * Runtime: 140 ms, faster than 89.71% of Kotlin online submissions for Divide Two Integers.
 * Memory Usage: 33.5 MB, less than 60.29% of Kotlin online submissions for Divide Two Integers.
 */
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val sameSign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)
        var absDivisor = -Math.abs(divisor)
        var absDividend = -Math.abs(dividend)
        
        var temp = absDivisor
        var count = 1
        var result = 0
        
        val maxValueShifted = Int.MIN_VALUE shr 1
        
        while (absDividend <= absDivisor) {
            while (temp >= absDividend) {
                if (temp > maxValueShifted) {
                    temp = temp shl 1
                    count = count shl 1
                } else {
                    break
                }
            }
            
            temp = temp shr 1
            count = count shr 1
            val maxValue = Int.MAX_VALUE - count
            if (count == 0) {
                count = 1
                temp = absDivisor
            }
            if (result < maxValue) {
                result += count
            } else {
                result = if (sameSign) {
                    Int.MAX_VALUE 
                } else if (result > maxValue) Int.MIN_VALUE else Int.MAX_VALUE
                break
            }
            absDividend -= temp
            temp = absDivisor
            count = 1
        }
        
        return if (sameSign) result else -result
    }
}
