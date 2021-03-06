/**
 * Runtime: 156 ms, faster than 98.16% of Kotlin online submissions for Maximum Depth of Binary Tree.
 * Memory Usage: 35.4 MB, less than 96.01% of Kotlin online submissions for Maximum Depth of Binary Tree.
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
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
    
    
}
