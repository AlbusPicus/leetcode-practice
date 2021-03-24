/**
 * Runtime: 220 ms, faster than 63.54% of Kotlin online submissions for Binary Tree Maximum Path Sum.
 * Memory Usage: 39.4 MB, less than 62.50% of Kotlin online submissions for Binary Tree Maximum Path Sum.
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
    fun maxPathSum(root: TreeNode?): Int {
        val completePathMap = mutableMapOf<TreeNode, Int>()
        root?.let { maxPathTillNode(it, completePathMap) }
        var result = Int.MIN_VALUE
        completePathMap.entries.forEach { pathSumEntry ->
            result = Math.max(result, pathSumEntry.value)
        }
        return result
    }
    
    fun maxPathTillNode(root: TreeNode, completePathMap: MutableMap<TreeNode,Int>): Int {
        val left = root.left?.let { maxPathTillNode(it, completePathMap) }?.takeIf { it > 0 } ?: 0
        val right = root.right?.let { maxPathTillNode(it, completePathMap) }?.takeIf { it > 0 } ?: 0
        completePathMap[root] = root.`val` + left + right
        return root.`val` + if (left > right) left else right
    }
    
}
