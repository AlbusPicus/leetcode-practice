/**
 * Runtime: 228 ms, faster than 43.96% of Kotlin online submissions for Roman to Integer.
 * Memory Usage: 37.3 MB, less than 29.30% of Kotlin online submissions for Roman to Integer.
 */
class Solution {
    fun romanToInt(s: String): Int {
        val chars = s.toCharArray()
        var result = 0
        var index = 0
        while (index < chars.size) {
            val char = chars[index]
            val exceptions = exceptionsMap.get(char)
            if (exceptions != null && index + 1 < chars.size && chars[index + 1] in exceptions) {
                result += conversionMap.getValue(chars[index + 1]) - conversionMap.getValue(char)
                index += 2
            } else {
                result += conversionMap.getValue(char)
                index += 1
            }
        }
        return result
    }
    
    companion object {
        private val exceptionsMap = mapOf(
            'I' to setOf('V', 'X'),
            'X' to setOf('L', 'C'),
            'C' to setOf('D', 'M')
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
