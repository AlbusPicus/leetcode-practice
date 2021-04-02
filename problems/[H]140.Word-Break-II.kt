/**
 * Runtime: 148 ms, faster than 100.00% of Kotlin online submissions for Word Break II.
 * Memory Usage: 35.4 MB, less than 89.74% of Kotlin online submissions for Word Break II.
 */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val trie = buildTrie(wordDict)
        
        return buildWordBreak(s, trie)
    }
    
    private fun buildWordBreak(text: String, trie: Trie): List<String> {
        if (text.isEmpty()) return listOf("")
        
        var currentTrie = trie
        val result = mutableListOf<String>()
        for (i in 0 until text.length) {
            val char = text[i]
            val index = char.toInt() - 'a'.toInt()
            val nextTrie = currentTrie.nodes[index]
            if (nextTrie == null) {
                return result
            } else {
                if (nextTrie.wordEnd) {
                    val nextResult = buildWordBreak(text.substring(i + 1), trie)
                    val word = text.substring(0, i + 1)
                    val mapped = nextResult.map { sentence ->
                        if (sentence.isEmpty()) {
                            word
                        } else {
                            word + " " + sentence
                        }
                    }
                    result.addAll(mapped)
                }
                currentTrie = nextTrie
            }
        }
        return result
    }
    
    private fun buildTrie(wordDict: List<String>): Trie {
        val trie = Trie()
        wordDict.forEach { word ->
            var currentTrie = trie
            word.forEach { char ->
                val index = char.toInt() - 'a'.toInt()
                val nextTrie = currentTrie.nodes[index] ?: Trie()
                currentTrie.nodes[index] = nextTrie
                currentTrie = nextTrie
            }
            currentTrie.wordEnd = true
        }
        return trie
    }
}

class Trie {
    
    val nodes = Array<Trie?>(26) { null }
    var wordEnd: Boolean = false
    
}
