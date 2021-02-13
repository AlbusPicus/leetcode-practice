/**
 * Runtime: 196 ms, faster than 100.00% of Kotlin online submissions for Surrounded Regions.
 * Memory Usage: 40.3 MB, less than 69.23% of Kotlin online submissions for Surrounded Regions.
 */
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val height = board.size
        if (height == 0) return
        
        val width = board[0].size
        val transformSafeQueue = LinkedList<Int>()
        
        var index = 0
        for (i in 0 until height) {
            if (board[i][index] == TARGET_CHAR) {
                transformSafeQueue.offerLast(i * width + index)
            }
        }
        index = width - 1
        for (i in 0 until height) {
            if (board[i][index] == TARGET_CHAR) {
                transformSafeQueue.offerLast(i * width + index)
            }
        }
        index = 0
        for (j in 0 until width) {
            if (board[index][j] == TARGET_CHAR) {
                transformSafeQueue.offerLast(index * width + j)
            }
        }
        index = height - 1
        for (j in 0 until width) {
            if (board[index][j] == TARGET_CHAR) {
                transformSafeQueue.offerLast(index * width + j)
            }
        }
        
        transformSafe(board, transformSafeQueue)
        
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
    
    fun transformSafe(board: Array<CharArray>, queue: LinkedList<Int>) {
        val height = board.size
        val width = board[0].size
        
        val R = listOf(0, 1, 0, -1)
        val C = listOf(-1, 0, 1, 0)
        
        while (queue.isNotEmpty()) {
            val point = queue.pollFirst()
            val i = point / width
            val j = point % width
            
            if (board[i][j] != TARGET_CHAR) continue
            
            board[i][j] = SAFE_CHAR
            
            for (index in 0 until R.size) {
                val newI = i + R[index]
                val newJ = j + C[index]
                if (newI >= 0 && newJ >= 0 && newI < height && newJ < width) {
                    val newPoint = newI*width + newJ
                    queue.offerLast(newPoint)
                }
            }
        }
    }
    
    companion object {
        const val REGULAR_CHAR = 'X'
        const val TARGET_CHAR = 'O'
        const val SAFE_CHAR = '1'
    }
}
