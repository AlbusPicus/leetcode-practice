/**
 * Runtime: 192 ms, faster than 44.44% of Kotlin online submissions for Sum of Left Leaves.
 * Memory Usage: 34.6 MB, less than 33.33% of Kotlin online submissions for Sum of Left Leaves.
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
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return root?.let { getLeftLeavesSum(it, false) } ?: 0
    }
    
    private fun getLeftLeavesSum(node: TreeNode, isLeft: Boolean): Int {
        return if (node.left == null && node.right == null && isLeft) {
            node.`val`
        } else {
            val leftSum = node.left?.let { getLeftLeavesSum(it, true) } ?: 0 
            val rightSum = node.right?.let { getLeftLeavesSum(it, false) } ?: 0
            leftSum + rightSum
        }
    }
    
}
