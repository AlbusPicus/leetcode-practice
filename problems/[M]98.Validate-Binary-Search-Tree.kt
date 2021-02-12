/**
 * Runtime: 168 ms, faster than 94.18% of Kotlin online submissions for Validate Binary Search Tree.
 * Memory Usage: 35.6 MB, less than 80.95% of Kotlin online submissions for Validate Binary Search Tree.
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
    fun isValidBST(root: TreeNode?): Boolean {
        return root?.isValid(null, null) ?: false
    }
    
    private fun TreeNode.isValid(min: Int?, max: Int?): Boolean {
        val isValueValid = (min == null || min < `val`) && (max == null || max > `val`)
        val isValidLeft = left?.isValid(min, `val`) ?: true
        val isValidRight = right?.isValid(`val`, max) ?: true
        return isValueValid && isValidLeft && isValidRight
    }
}
