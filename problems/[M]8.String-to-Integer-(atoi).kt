/**
 * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for String to Integer (atoi).
 * Memory Usage: 35.2 MB, less than 86.89% of Kotlin online submissions for String to Integer (atoi).
 */
class Solution {
    fun myAtoi(s: String): Int {
        var skippedCharsCount = 0
        while (skippedCharsCount < s.length && s.get(skippedCharsCount) == ' ') {
            skippedCharsCount++
        }
        var isPositive = true
        if (skippedCharsCount < s.length) {
            val char = s.get(skippedCharsCount) 
            if (char == '-' || char == '+') {
                skippedCharsCount++
            }
            isPositive = char != '-'
        }
        
        var result = 0
        for (i in skippedCharsCount until s.length) {
            val char = s.get(i)
            if (char >= '0' && char <= '9') {
                if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && char > '7')) {
                    return if (isPositive) Int.MAX_VALUE else Int.MIN_VALUE
                }
                result *= 10
                result += char - '0'
            } else {
                break
            }
        }
        return if (isPositive) result else -result
    }
}
