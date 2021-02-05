/**
 * Runtime: 144 ms, faster than 98.17% of Kotlin online submissions for Count and Say.
 * Memory Usage: 35.3 MB, less than 80.73% of Kotlin online submissions for Count and Say.
 */
class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"
        
        val previousCountAndSay = countAndSay(n - 1)
        var result = StringBuilder()
        var currentDigit = previousCountAndSay.get(0)
        var currentDigitCount = 0
        previousCountAndSay.forEach { digit ->
            if (digit == currentDigit) {
                currentDigitCount++
            } else {
                result.append(currentDigitCount).append(currentDigit)
                currentDigit = digit
                currentDigitCount = 1
            }
        }
        result.append(currentDigitCount).append(currentDigit)
        return result.toString()
    }
}
