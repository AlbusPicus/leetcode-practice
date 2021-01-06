/**
 * Runtime: 160 ms, faster than 100.00% of Kotlin online submissions for Delete Columns to Make Sorted II.
 * Memory Usage: 35.5 MB, less than 100.00% of Kotlin online submissions for Delete Columns to Make Sorted II.
 */
class Solution {
    fun minDeletionSize(A: Array<String>): Int {
        val rows = A.size
        val columns = A[0].length
        
        val distinctRows = Array<Boolean>(rows - 1) { false }

        var deletedColumns = 0
        for (column in 0 until columns) {
            var skip = false
            for (row in 0 until rows - 1) {
                if (!distinctRows[row] && A[row].get(column) > A[row + 1].get(column)) {
                    deletedColumns++
                    skip = true
                    break
                }
            }
            if (skip) continue

            for (row in 0 until rows - 1) {
                if (A[row].get(column) < A[row + 1].get(column)) {
                    distinctRows[row] = true
                }
            }
        }

        return deletedColumns
    }
}
