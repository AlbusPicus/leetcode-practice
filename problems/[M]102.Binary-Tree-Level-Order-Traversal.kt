/**
 * Runtime: 176 ms, faster than 93.86% of Kotlin online submissions for Binary Tree Level Order Traversal.
 * Memory Usage: 35.4 MB, less than 98.68% of Kotlin online submissions for Binary Tree Level Order Traversal.
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val traverseQueue = LinkedList<TreeNode>()
        root?.let { traverseQueue.offerLast(it) }
        
        val result = mutableListOf<List<Int>>()
        while (traverseQueue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            val levelSize = traverseQueue.size
            for (i in 0 until levelSize) {
                val node = traverseQueue.pollFirst()
                currentLevel.add(node.`val`)
                node.left?.let { traverseQueue.offerLast(it) }
                node.right?.let { traverseQueue.offerLast(it) }
            }
            
            result.add(currentLevel)
        }
        return result
    }
}
