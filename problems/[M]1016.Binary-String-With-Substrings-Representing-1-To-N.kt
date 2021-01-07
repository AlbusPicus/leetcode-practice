/**
 * Runtime: 136 ms, faster than 66.67% of Kotlin online submissions for Binary String With Substrings Representing 1 To N.
 * Memory Usage: 33.1 MB, less than 66.67% of Kotlin online submissions for Binary String With Substrings Representing 1 To N.
 */
class Solution {
    fun queryString(S: String, N: Int): Boolean {
        for (i in 1 .. N) {
            if (!isInString(S, i)) {
                return false
            }
        }
        return true
    }
    
    fun isInString(S: String, N: Int): Boolean {
        var currentNumber = 0
        S.forEachIndexed { index, char ->
            val digit = char.toInt() - ZERO_CHAR_INT
            val temp = (currentNumber shl 1) + digit
            currentNumber = if (temp > N) {
                var deductionNumber = 1
                while (deductionNumber < temp) {
                    deductionNumber = deductionNumber shl 1
                }
                deductionNumber = deductionNumber shr 1
                val result = temp - deductionNumber
                result
            } else temp
            
            if (currentNumber == N) {
                return true
            }
        }
        return false
    }
    
    companion object {       
        const val ZERO_CHAR_INT = '0'.toInt()
    }
}
