/**
 * Runtime: 312 ms, faster than 48.72% of Kotlin online submissions for Surrounded Regions.
 * Memory Usage: 45.5 MB, less than 48.72% of Kotlin online submissions for Surrounded Regions.
 */
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val height = board.size
        if (height == 0) return
        
        val width = board[0].size
        
        for (i in 1 until height - 1) {
            for (j in 1 until width - 1) {
                if (board[i][j] == TARGET_CHAR) {
                    if (isSurrounded(board, i, j)) {
                        // System.out.println("CAPTURE! $i / $j")
                        capture(board, i, j)
                    } else {
                        // System.out.println("SAFE! $i / $j")
                        transformSafe(board, i, j)
                    }
                }
            }
        }
        
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (board[i][j] == SAFE_CHAR) {
                    board[i][j] = TARGET_CHAR
                }
            }
        }
    }
    
    inline fun traverseRegion(board: Array<CharArray>, row: Int, column: Int, action: (Int, Int) -> Unit) {
        val visited = mutableSetOf<Int>()
        val height = board.size
        val width = board[0].size
        
        val R = listOf(0, 1, 0, -1)
        val C = listOf(-1, 0, 1, 0)
        
        val queue = LinkedList<Int>()
        queue.offerLast(row * width + column)
        
        while (queue.isNotEmpty()) {
            val point = queue.pollFirst()
            val i = point / width
            val j = point % width
            
            if (point in visited || isOverBorder(board, i, j) || board[i][j] != TARGET_CHAR) continue
            
            action(i,j)
            
            for (index in 0 until R.size) {
                val newPoint = (i + R[index])*width + j + C[index]
                queue.offerLast(newPoint)
            }
            visited.add(point)
        }
    }
    
    private fun isSurrounded(board: Array<CharArray>, row: Int, column: Int): Boolean {
        traverseRegion(board, row, column) { i, j ->
            if (isOnBorder(board, i, j)) {
                // System.out.println("ON BORDER! $i / $j")
                return false
            }
        }
        return true
    }
    
    private fun capture(board: Array<CharArray>, row: Int, column: Int) {
        traverseRegion(board, row, column) { i, j ->
            board[i][j] = REGULAR_CHAR
        }
    }
    
    private fun transformSafe(board: Array<CharArray>, row: Int, column: Int) {
        traverseRegion(board, row, column) { i, j ->
            board[i][j] = SAFE_CHAR
        }
    }
    
    fun isOnBorder(board: Array<CharArray>, i: Int, j: Int): Boolean {
        return i == 0 || j == 0 || i == board.lastIndex || j == board[0].lastIndex
    }
    
    fun isOverBorder(board: Array<CharArray>, i: Int, j: Int): Boolean {
        return i < 0 || j < 0 || i > board.lastIndex || j > board[0].lastIndex
    }
    
    companion object {
        const val REGULAR_CHAR = 'X'
        const val TARGET_CHAR = 'O'
        const val SAFE_CHAR = '1'
    }
}
