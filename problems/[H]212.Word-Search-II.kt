/**
 * Runtime: 1240 ms, faster than 14.89% of Kotlin online submissions for Word Search II.
 * Memory Usage: 61.3 MB, less than 6.38% of Kotlin online submissions for Word Search II.
 */
class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        
        val headTrie = Trie()
        fillTrie(headTrie, words)
        
        val result = mutableSetOf<String>()
        val delimeter = Math.max(board.size, board[0].size)
        val visited = mutableSetOf<Int>()
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                val position = i * delimeter + j
                val words = fillWordsFromPosition(board, position, headTrie, visited, result)
            }
        }
        return result.toList()
    }
    
    private fun fillWordsFromPosition(board: Array<CharArray>, position: Int, headTrie: Trie, visited: MutableSet<Int>, result: MutableSet<String>) {
        if (position in visited) return
        
        val delimeter = Math.max(board.size, board[0].size)
        val i = position / delimeter
        val j = position % delimeter
        val char = board[i][j]
        val charIndex = char.toInt() - 'a'.toInt()
        
        headTrie.childs[charIndex]?.let { nextTrie ->
            nextTrie.word?.let { word ->
                result.add(word)
            }

            visited.add(position)
            if (j > 0) {
                val left = i * delimeter + j - 1
                fillWordsFromPosition(board, left, nextTrie, visited, result)
            }
            if (i > 0) {
                val top = (i - 1) * delimeter + j
                fillWordsFromPosition(board, top, nextTrie, visited, result)
            }
            if (j < board[0].size - 1) {
                val right = i * delimeter + j + 1
                fillWordsFromPosition(board, right, nextTrie, visited, result)
            }
            if (i < board.size - 1) {
                val bottom = (i + 1) * delimeter + j
                fillWordsFromPosition(board, bottom, nextTrie, visited, result)
            }
            visited.remove(position)
        }
    }
    
    private fun fillTrie(headTrie: Trie, words: Array<String>) {
        words.forEach { word ->
            var currentTrie = headTrie
            word.forEach { char ->
                val index = char.toInt() - 'a'.toInt()
                val nextTrie = currentTrie.childs[index] ?: Trie()
                currentTrie.childs[index] = nextTrie
                currentTrie = nextTrie
            }
            currentTrie.word = word
        }
    }
}

class Trie {
    var word: String? = null
    val childs = Array<Trie?>(26) { null }
}
