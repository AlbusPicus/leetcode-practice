/**
 * Runtime: 132 ms, faster than 85.71% of Kotlin online submissions for Fraction to Recurring Decimal.
 * Memory Usage: 35.3 MB, less than 14.29% of Kotlin online submissions for Fraction to Recurring Decimal.
 */
class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        var result = ""
        var carry = 0L
        val unsignedNumerator = Math.abs(numerator.toLong())
        val unsignedDenominator = Math.abs(denominator.toLong())
        val isNegative = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)
        unsignedNumerator.toString().forEach { numStr ->
            carry = 10L * carry + numStr.toString().toInt()
            if (carry / unsignedDenominator > 0L) {
                result += carry / unsignedDenominator
                carry = carry % unsignedDenominator
            } else if (result.isNotEmpty()) {
                result += "0"
            }
        }
        
        if (result.isEmpty()) {
            result += "0"
        }
        if (carry > 0L) {
            val carryIndexes = mutableMapOf<Long, Int>()
            result += "."
            while (carry > 0L) {
                if (carry in carryIndexes.keys) {
                    result += ")"
                    val insertIndex = carryIndexes[carry]!!
                    result = result.substring(0, insertIndex) + "(" + result.substring(insertIndex)
                    carry = 0L
                } else {
                    carryIndexes[carry] = result.length
                    carry = 10L * carry
                    result += carry / unsignedDenominator
                    carry = carry % unsignedDenominator
                }
            }
        }
        
        return if (isNegative) "-$result" else result
        
    }
    
}
