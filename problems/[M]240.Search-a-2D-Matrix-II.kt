/**
 * Runtime: 236 ms, faster than 91.07% of Kotlin online submissions for Search a 2D Matrix II.
 * Memory Usage: 45.3 MB, less than 62.50% of Kotlin online submissions for Search a 2D Matrix II.
 */
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var endIndex = matrix[0].lastIndex
        
        for (i in 0 until matrix.size) {
            val row = matrix[i]
            var start = 0
            var end = endIndex
            while (start < end) {
                val mid = start + (end - start + 1) / 2
                if (row[mid] > target) {
                    end = mid - 1
                } else if (row[mid] < target) {
                    start = mid
                } else {
                    return true
                }
            }
            val mid = start + (end - start + 1) / 2
            if (row[mid] == target) return true
            endIndex = mid
        }
        return false
    }
}
