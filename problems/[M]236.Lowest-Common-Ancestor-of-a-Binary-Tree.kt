/**
 * Runtime: 180 ms, faster than 99.01% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
 * Memory Usage: 36.3 MB, less than 72.28% of Kotlin online submissions for Lowest Common Ancestor of a Binary Tree.
 */


/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root != null) {
            if (root.`val` == p?.`val` || root.`val` == q?.`val`) {
                return root
            } else {
                val left = lowestCommonAncestor(root?.left, p, q)
                val right = lowestCommonAncestor(root?.right, p, q)
                return if (left != null && right != null) {
                    root 
                } else {
                    left ?: right
                }
            }
        } else {
            return null
        }
    }
}
