/**
 * Runtime: 164 ms, faster than 92.11% of Kotlin online submissions for Pow(x, n).
 * Memory Usage: 35.3 MB, less than 78.95% of Kotlin online submissions for Pow(x, n).
 */
class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        val remainderSet = mutableSetOf<Double>()
        
        val baseMultiplier = if (n < 0) 1 / x else x
        var multiplier = baseMultiplier
        var multiplyNumber = n
        while (multiplyNumber > 1 || multiplyNumber < -1) {
            val remainder = multiplyNumber % 2
            if (remainder != 0) {
                remainderSet.add(multiplier)
            }
            
            multiplier *= multiplier
            multiplyNumber /= 2            
        }
        var resultBase = multiplier
        remainderSet.forEach { number ->
            resultBase *= number
        }
        return resultBase
    }
    
}
