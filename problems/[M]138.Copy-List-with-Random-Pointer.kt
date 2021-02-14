/**
 * Runtime: 176 ms, faster than 75.10% of Kotlin online submissions for Copy List with Random Pointer.
 * Memory Usage: 35.5 MB, less than 82.45% of Kotlin online submissions for Copy List with Random Pointer.
 */
/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        val randomPointerMap = mutableMapOf<Node, Node?>()
        val newNodeMap = mutableMapOf<Node, Node>()
        
        var previousNewNode: Node? = null
        var nodeIterator = node
        while (nodeIterator != null) {
            val newNode = Node(nodeIterator.`val`)
            previousNewNode?.let { it.next = newNode }
            previousNewNode = newNode
            
            randomPointerMap[nodeIterator] = nodeIterator.random
            newNodeMap[nodeIterator] = newNode
            
            nodeIterator = nodeIterator.next
        }
        
        randomPointerMap.entries.forEach { (node, randomNode) ->
            newNodeMap[node]?.random = newNodeMap[randomNode]
        }
        
        return newNodeMap[node]
        
    }
}
