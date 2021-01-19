/**
 * Runtime: 136 ms, faster than 76.47% of Kotlin online submissions for N-Queens II.
 * Memory Usage: 35.7 MB, less than 23.53% of Kotlin online submissions for N-Queens II.
 */
class Solution {
    fun totalNQueens(n: Int): Int {
        val board = Array<IntArray>(n) { IntArray(n) { 0 } }
        return getSuccessfulPlacementsCount(board, 0)
    }
    
    fun getSuccessfulPlacementsCount(board: Array<IntArray>, rowIndex: Int): Int {
        val boardSize = board.size
        var variants = 0
        if (rowIndex == boardSize - 1) {
            for (i in 0 until boardSize) {
                if (board[rowIndex][i] == 0) {
                    variants++
                }
            }
        } else {
            val boardCut = Array<IntArray>(boardSize - rowIndex) { i -> 
                IntArray(board.size) { j -> 
                    board[rowIndex + i][j]
                } 
            }
            
            for (i in 0 until boardSize) {
                if (board[rowIndex][i] == 0) {
                    placeQueen(board, rowIndex, i)
                    variants += getSuccessfulPlacementsCount(board, rowIndex + 1)
                    clearBoard(board, boardCut)
                }
            }
        }
        return variants
    }
    
    fun placeQueen(board: Array<IntArray>, rowIndex: Int, columnIndex: Int) {
        board[rowIndex][columnIndex] = 1
        var leftIndex = columnIndex - 1
        var rightIndex = columnIndex + 1
        for (i in rowIndex + 1 until board.size) {
            board[i][columnIndex] = 1
            if (leftIndex >= 0) {
                board[i][leftIndex] = 1
                leftIndex--
            }
            if (rightIndex < board.size) {
                board[i][rightIndex] = 1
                rightIndex++
            }
        }
    }
    
    fun clearBoard(board: Array<IntArray>, boardCut: Array<IntArray>) {
        val rowsToUpdate = boardCut.size
        val startIndex = board.size - boardCut.size
        for (i in startIndex until board.size) {
            for (j in 0 until board.size) {
                board[i][j] = boardCut[i - startIndex][j]
            }
        }
    }
    
}
