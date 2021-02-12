/**
 * Runtime: 152 ms, faster than 100.00% of Kotlin online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 35.5 MB, less than 77.63% of Kotlin online submissions for Binary Tree Zigzag Level Order Traversal.
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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val queue = LinkedList<TreeNode>()
        root?.let { queue.offerLast(it) }
        
        val result = mutableListOf<List<Int>>()
        var leftToRight = true
        while (queue.isNotEmpty()) {
            val currentLevel = mutableListOf<Int>()
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val node = queue.pollFirst()
                if (leftToRight) {
                    currentLevel.add(node.`val`)
                } else {
                    currentLevel.add(0, node.`val`)
                }
                node.left?.let { queue.offerLast(it) }
                node.right?.let { queue.offerLast(it) }
            }
            
            result.add(currentLevel)
            leftToRight = !leftToRight
        }
        
        return result
    }
}
