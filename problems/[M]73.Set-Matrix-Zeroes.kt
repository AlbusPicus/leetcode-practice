/**
 * Runtime: 256 ms, faster than 66.67% of Kotlin online submissions for Set Matrix Zeroes.
 * Memory Usage: 44.5 MB, less than 62.32% of Kotlin online submissions for Set Matrix Zeroes.
 */
class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = mutableSetOf<Int>()
        val columns = mutableSetOf<Int>()
        
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    rows.add(i)
                    columns.add(j)
                }
            }
        }
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (i in rows || j in columns) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}
