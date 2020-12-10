/**
 * Runtime: 428 ms, faster than 50.00% of Kotlin online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 * Memory Usage: 	51.6 MB, less than 100.00% of Kotlin online submissions for Pseudo-Palindromic Paths in a Binary Tree.
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
    
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        return findPseudoPalendromeCount(root, mutableSetOf<Int>())
    }
    
    fun findPseudoPalendromeCount(node: TreeNode?, unpairedNumbersSet: MutableSet<Int>): Int {
        return if (node != null) {

            val isUnpaired = node.`val` in unpairedNumbersSet
            if (isUnpaired) {
                unpairedNumbersSet.remove(node.`val`)
            } else {
                unpairedNumbersSet.add(node.`val`)
            }

            val pseudoPalendromeCount = if (node.left != null || node.right != null) {
                val leftPseudoPalendrome = findPseudoPalendromeCount(node.left, unpairedNumbersSet) 
                val rightPseudoPalendrome = findPseudoPalendromeCount(node.right, unpairedNumbersSet) 
                leftPseudoPalendrome + rightPseudoPalendrome
            } else {
                if (unpairedNumbersSet.size <= 1) 1 else 0
            }

            if (isUnpaired) {
                unpairedNumbersSet.add(node.`val`)
            } else {
                unpairedNumbersSet.remove(node.`val`)
            }
            
            pseudoPalendromeCount
        } else 0
    }
    
}
