/**
 * Runtime: 184 ms, faster than 94.69% of Kotlin online submissions for Valid Sudoku.
 * Memory Usage: 40.4 MB, less than 84.96% of Kotlin online submissions for Valid Sudoku.
 */
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array<BooleanArray>(9) { BooleanArray(9) }
        val columns = Array<BooleanArray>(9) { BooleanArray(9) }
        val boxes = Array<BooleanArray>(9) { BooleanArray(9) }

        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                val value = board[i][j]
                if (value != EMPTY_CHAR) {
                    val number = value.toInt() - '1'.toInt()
                    val boxIndex = i / 3 + 3 * (j / 3)
                    
                    if (rows[i][number] == true) return false
                    if (columns[j][number] == true) return false
                    if (boxes[boxIndex][number] == true) return false
                    
                    rows[i][number] = true
                    columns[j][number] = true
                    boxes[boxIndex][number] = true
                }
            }
        }
        return true
    }
    
    companion object {
        const val EMPTY_CHAR = '.'
    }
}
