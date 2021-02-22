/**
 * Runtime: 324 ms, faster than 94.44% of Kotlin online submissions for Implement Trie (Prefix Tree).
 * Memory Usage: 47.4 MB, less than 91.67% of Kotlin online submissions for Implement Trie (Prefix Tree).
 */
class Trie() {

    /** Initialize your data structure here. */
    val head = Node()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = head
        word.forEach { char ->
            val index = char - 'a'
            val nextNode = node.childs[index] ?: let {
                Node().also { newNode ->
                    node.childs[index] = newNode
                }                
            }
            node = nextNode
        }
        node.wordEnd = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        val node = getLastNode(word)
        return node != null && node.wordEnd
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        val node = getLastNode(prefix)
        return node != null
    }
    
    private fun getLastNode(word: String): Node? {
        var node: Node? = head
        for (i in 0 until word.length) {
            val index = word[i] - 'a'
            node = node?.childs?.get(index)
            
            if (node == null) break
        }
        return node
    }

}

class Node {
    var wordEnd = false
    val childs = Array<Node?>(26) { null }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
