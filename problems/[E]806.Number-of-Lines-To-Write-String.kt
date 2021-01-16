/**
 * Runtime: 144 ms, faster than 80.00% of Kotlin online submissions for Number of Lines To Write String.
 * Memory Usage: 34 MB, less than 80.00% of Kotlin online submissions for Number of Lines To Write String.
 */
class Solution {
    fun numberOfLines(widths: IntArray, s: String): IntArray {
        val alphabetStartIndex = 'a'.toInt()
        var currentWidth = 0
        var fullLinesCount = 0
        s.forEach { char ->
            val index = char.toInt() - alphabetStartIndex
            val width = widths[index]
            if (currentWidth + width > 100) {
                currentWidth = width
                fullLinesCount++
            } else {
                currentWidth += width
            }
        }
        
        val linesCount = fullLinesCount + if (currentWidth > 0) 1 else 0
        return intArrayOf(linesCount, currentWidth)
    }
}
