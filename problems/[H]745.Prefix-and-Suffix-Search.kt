/**
 * Runtime: 1040 ms, faster than 75.00% of Kotlin online submissions for Prefix and Suffix Search.
 * Memory Usage: 102.2 MB, less than 25.00% of Kotlin online submissions for Prefix and Suffix Search.
 */
class WordFilter(words: Array<String>) {
    
    val trie = TrieNode()
    
    init {
        words.forEachIndexed { wordIndex, word ->
            var currentTrie = trie
            currentTrie.lastWordIndex = wordIndex
            
            val chars = word.toCharArray()
            val charsLength = chars.size
            
            for (i in 0 until charsLength) {
                var tmp = currentTrie
                
                for (j in i until charsLength) {
                    val childKey = (chars[j] - SYMBOL_BEFORE_FIRST_LETTER_INT) * PREFIX_MULTIPLIER
                    val node = tmp.children.get(childKey) ?: let {
                        TrieNode().also {
                            tmp.children.put(childKey, it)
                        }
                    }
                    tmp = node
                    tmp.lastWordIndex = wordIndex
                }
                
                tmp = currentTrie
                for (k in charsLength - 1 - i downTo 0) {
                    val childKey = chars[k] - SYMBOL_BEFORE_FIRST_LETTER_INT
                    val node = tmp.children.get(childKey) ?: let {
                        TrieNode().also {
                            tmp.children.put(childKey, it)
                        }
                    }
                    tmp = node
                    tmp.lastWordIndex = wordIndex
                }
                
                val index = (chars[i] - SYMBOL_BEFORE_FIRST_LETTER_INT) * PREFIX_MULTIPLIER + (chars[charsLength - 1 - i] - SYMBOL_BEFORE_FIRST_LETTER_INT)
                val node = currentTrie.children.get(index) ?: let {
                    TrieNode().also {
                        currentTrie.children.put(index, it)
                    }
                }
                currentTrie = node
                currentTrie.lastWordIndex = wordIndex
            }
        }
    }

    fun f(prefix: String, suffix: String): Int {
        var currentTrie = trie
        var prefixIndex = 0
        var suffixIndex = suffix.length - 1
        while (prefixIndex < prefix.length || suffixIndex >= 0) {
            val prefixChar = if (prefixIndex < prefix.length) {
                prefix.get(prefixIndex) 
            } else { 
                SYMBOL_BEFORE_FIRST_LETTER_INT
            }
            val suffixChar = if (suffixIndex >= 0) {
                suffix.get(suffixIndex) 
            } else {
                SYMBOL_BEFORE_FIRST_LETTER_INT
            }
            val index = (prefixChar - SYMBOL_BEFORE_FIRST_LETTER_INT) * PREFIX_MULTIPLIER + (suffixChar - SYMBOL_BEFORE_FIRST_LETTER_INT)
            currentTrie.children.get(index)?.let {
                currentTrie = it
            } ?: return -1
            prefixIndex++
            suffixIndex--
        }
        return currentTrie.lastWordIndex
    }
    
    class TrieNode {
        val children = mutableMapOf<Int, TrieNode>()
        var lastWordIndex = 0
    }
    
    companion object {
        const val PREFIX_MULTIPLIER = 27
        const val SYMBOL_BEFORE_FIRST_LETTER_INT = 'a' - 1
    }
    
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * var obj = WordFilter(words)
 * var param_1 = obj.f(prefix,suffix)
 */
