/**
 * Runtime: 156 ms, faster than 79.05% of Kotlin online submissions for Game of Life.
 * Memory Usage: 36.2 MB, less than 44.59% of Kotlin online submissions for Game of Life.
 */
class Solution {
    private val R = listOf(-1, 0, 1, -1, 1, -1, 0, 1)
    private val C = listOf(-1, -1, -1, 0, 0, 1, 1, 1)
    
    fun gameOfLife(board: Array<IntArray>): Unit {
        val height = board.size
        val width = board[0].size
        
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (board[i][j] > 0) {
                    affectByLiving(board, i, j)
                }
            }
        }
        
        for (i in 0 until height) {
            for (j in 0 until width) {
                when {
                    board[i][j] == -3 -> board[i][j] = 1
                    board[i][j] > 4 -> board[i][j] = 0
                    board[i][j] == 3 -> board[i][j] = 1
                    board[i][j] == 4 -> board[i][j] = 1
                    else -> board[i][j] = 0
                }
            }
        }
    }
    
    private fun affectByLiving(board: Array<IntArray>, row: Int, column: Int) {
        val size = R.size
        
        for (k in 0 until size) {
            val i = row - R[k]
            val j = column - C[k]
            if (i >= 0 && i < board.size && j >= 0 && j < board[0].size) {
                if (board[i][j] > 0) {
                    board[i][j]++
                } else {
                    board[i][j]--
                }
            }
        }
    }
}
