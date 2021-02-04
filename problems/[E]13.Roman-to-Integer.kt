/**
 * Runtime: 200 ms, faster than 82.42% of Kotlin online submissions for Roman to Integer.
 * Memory Usage: 35.5 MB, less than 84.98% of Kotlin online submissions for Roman to Integer.
 */
class Solution {
    fun romanToInt(s: String): Int {
        val chars = s.toCharArray()
        var result = 0
        var subtractionChar: Char? = null
        for (i in chars.size - 1 downTo 0) {
            val char = chars[i]
            val value = conversionMap.getValue(char)
            if (char == subtractionChar) {
                result -= value
            } else {
                result += value
            }
            subtractionChar = subtractionMap[char]
        }
        return result
    }
    
    companion object {
         private val subtractionMap = mapOf(
            'V' to 'I',
            'X' to 'I',
            'L' to 'X',
            'C' to 'X',
            'D' to 'C',
            'M' to 'C'
        )
        private val conversionMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
    }
}
