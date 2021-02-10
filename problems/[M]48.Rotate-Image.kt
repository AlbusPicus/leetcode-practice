/**
 * Runtime: 168 ms, faster than 79.51% of Kotlin online submissions for Rotate Image.
 * Memory Usage: 35.3 MB, less than 90.16% of Kotlin online submissions for Rotate Image.
 */
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        val lastIndex = matrix.size - 1
        for (i in 0 .. size / 2) {
            for (j in i .. (lastIndex - i - 1)) {
                var currentValue = matrix[i][j]
                var nextValue = matrix[j][lastIndex - i]
                matrix[j][lastIndex - i] = currentValue
                currentValue = nextValue
                nextValue = matrix[lastIndex - i][lastIndex - j]
                matrix[lastIndex - i][lastIndex - j] = currentValue
                currentValue = nextValue
                nextValue = matrix[lastIndex - j][i]
                matrix[lastIndex - j][i] = currentValue
                matrix[i][j] = nextValue
            }
        }
    }
}
