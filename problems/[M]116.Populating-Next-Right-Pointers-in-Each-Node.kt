/**
 * Runtime: 188 ms, faster than 98.46% of Kotlin online submissions for Populating Next Right Pointers in Each Node.
 * Memory Usage: 36.3 MB, less than 81.54% of Kotlin online submissions for Populating Next Right Pointers in Each Node.
 */
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        val level = LinkedList<Node>()
        root?.let { level.offerLast(it) }
        while (level.isNotEmpty()) {
            val levelSize = level.size
            var lastNode: Node? = null
            for (i in 0 until levelSize) {
                val node = level.pollFirst()
                lastNode?.let { it.next = node }
                node.left?.let { level.offerLast(it) }
                node.right?.let { level.offerLast(it) }  
                lastNode = node
            }
        }
        return root
    }
}
