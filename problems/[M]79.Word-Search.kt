/**
 * Runtime: 248 ms, faster than 60.66% of Kotlin online submissions for Word Search.
 * Memory Usage: 45.1 MB, less than 37.71% of Kotlin online submissions for Word Search.
 */
class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (checkIfWordExists(board, i, j, word, 0, mutableSetOf<Int>())) return true
            }
        }
        return false
    }
    
    private fun checkIfWordExists(board: Array<CharArray>, i: Int, j: Int, word: String, charIndex: Int, usedIndexes: MutableSet<Int>): Boolean {
        if (charIndex == word.length) return true
        val char = word.get(charIndex)
        if (char != board[i][j]) return false
        
        val height = board.size
        val width = board[0].size
        val index = i*width + j
        val result = if (index in usedIndexes) {
            false
        } else {
            usedIndexes.add(index)
            val check = when {
                charIndex == word.length - 1 && char == board[i][j] -> true
                i > 0 && checkIfWordExists(board, i - 1, j, word, charIndex + 1, usedIndexes) -> true
                j > 0 && checkIfWordExists(board, i, j - 1, word, charIndex + 1, usedIndexes) -> true
                i < height - 1 && checkIfWordExists(board, i + 1, j, word, charIndex + 1, usedIndexes) -> true
                j < width - 1 && checkIfWordExists(board, i, j + 1, word, charIndex + 1, usedIndexes) -> true
                else -> false
            }
            usedIndexes.remove(index)
            check
        }
        return result
    }
}
