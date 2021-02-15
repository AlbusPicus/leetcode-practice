/**
 * Runtime: 312 ms, faster than 92.31% of Kotlin online submissions for LRU Cache.
 * Memory Usage: 48 MB, less than 96.15% of Kotlin online submissions for LRU Cache.
 */
class LRUCache(val capacity: Int) {
    
    var frequencyHead: Node? = null
    var frequencyTail: Node? = null
    val valuesMap = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        return valuesMap[key]?.let { node ->
            extractNode(node)
            insertNode(node)

            node.value
        } ?: -1
    }
    
    private fun extractNode(node: Node) {
        if (frequencyTail == node) {
            frequencyTail = node.left
        }
        if (frequencyHead == node) {
            frequencyHead = node?.right
        }
        node.left?.right = node.right
        node.right?.left = node.left
        node.left = null
        node.right = null
    }
    
    private fun insertNode(node: Node) {
        node.right = frequencyHead
        frequencyHead?.left = node
        frequencyHead = node
        
        if (frequencyTail == null) {
            frequencyTail = frequencyHead
        }
    }

    fun put(key: Int, value: Int) {
        valuesMap[key]?.let { currentNode ->
            currentNode.value = value
            
            extractNode(currentNode)
            insertNode(currentNode)
        } ?: let {
            val node = Node(key)
            node.value = value
            valuesMap[key] = node
            
            insertNode(node)
        }
        
        if (valuesMap.size > capacity) {
            frequencyTail?.let { node ->
                valuesMap.remove(node.key)
                extractNode(node)
            }
        }
    }
    
    data class Node(val key: Int) {
        var value: Int = 0
        var left: Node? = null
        var right: Node? = null
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
