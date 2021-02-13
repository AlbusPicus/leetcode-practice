/**
 * Runtime: 192 ms, faster than 100.00% of Kotlin online submissions for Surrounded Regions.
 * Memory Usage: 37.6 MB, less than 92.31% of Kotlin online submissions for Surrounded Regions.
 */
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val height = board.size
        if (height == 0) return
        
        val width = board[0].size
        
        var firstIndex = 0
        var lastIndex = width - 1
        for (i in 0 until height) {
            if (board[i][firstIndex] == TARGET_CHAR) {
                transformSafe(board, i, firstIndex)
            }
            if (board[i][lastIndex] == TARGET_CHAR) {
                transformSafe(board, i, lastIndex)
            }
        }
        firstIndex = 0
        lastIndex = height - 1
        for (j in 0 until width) {
            if (board[firstIndex][j] == TARGET_CHAR) {
                transformSafe(board, firstIndex, j)
            }
            if (board[lastIndex][j] == TARGET_CHAR) {
                transformSafe(board, lastIndex, j)
            }
        }
        
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (board[i][j] == TARGET_CHAR) {
                    board[i][j] = REGULAR_CHAR
                } else if (board[i][j] == SAFE_CHAR) {
                    board[i][j] = TARGET_CHAR
                }
            }
        }
        
    }
    fun transformSafe(board: Array<CharArray>, i: Int, j: Int) {
        val height = board.size
        val width = board[0].size
        if (i >= 0 && j >= 0 && i < height && j < width && board[i][j] == TARGET_CHAR) {
            board[i][j] = SAFE_CHAR
            transformSafe(board, i + 1, j)
            transformSafe(board, i - 1, j)
            transformSafe(board, i, j + 1)
            transformSafe(board, i, j - 1)
        }
    }
    
    companion object {
        const val REGULAR_CHAR = 'X'
        const val TARGET_CHAR = 'O'
        const val SAFE_CHAR = '1'
    }
}
