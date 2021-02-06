/**
 * Runtime: 152 ms, faster than 82.86% of Kotlin online submissions for Excel Sheet Column Number.
 * Memory Usage: 34.8 MB, less than 91.43% of Kotlin online submissions for Excel Sheet Column Number.
 */
class Solution {
    fun titleToNumber(s: String): Int {
        var columnNumber = 0
        s.forEach { char ->
            columnNumber = 26 * columnNumber + char.toInt() - 'A'.toInt() + 1
        }
        return columnNumber
    }
}
