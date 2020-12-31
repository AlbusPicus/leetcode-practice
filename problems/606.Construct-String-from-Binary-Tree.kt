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
 
 /**
  * Runtime: 220 ms, faster than 80.00% of Kotlin online submissions for Construct String from Binary Tree.
  * Memory Usage: 47 MB, less than 80.00% of Kotlin online submissions for Construct String from Binary Tree.
  */
class Solution {
    fun tree2str(t: TreeNode?): String {
        return t?.let { getSubtreeString(it) } ?: ""
    }
    
    fun getSubtreeString(node: TreeNode): String {
        val rightSubTreeString = if (node.right != null) "(${getSubtreeString(node.right)})" else ""
        val leftSubTreeString = if (node.left != null) {
            "(${getSubtreeString(node.left)})" 
        } else if (rightSubTreeString.isNotEmpty()) "()" else ""
        
        return "${node.`val`}" + leftSubTreeString + rightSubTreeString
    }
}
