/**
 * Runtime: 672 ms, faster than 16.67% of Kotlin online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 * Memory Usage: 70.2 MB, less than 16.67% of Kotlin online submissions for Pseudo-Palindromic Paths in a Binary Tree.
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
    
    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        return if (root != null) {
            dfs(root).count { it.size == 0 || it.size == 1}
        } else 0
    }
    
    fun dfs(node: TreeNode): MutableList<MutableSet<Int>> {
        val leftSet = node.left?.let {
            dfs(it) 
        }?.let { addValueToUnpairedNumberSets(it, node.`val`) }
        val rightSet = node.right?.let { 
            dfs(it) 
        }?.let { addValueToUnpairedNumberSets(it, node.`val`) }
        
        val result: MutableList<MutableSet<Int>> = if (leftSet != null) {
            rightSet?.let { leftSet.addAll(it) }
            leftSet
        } else rightSet ?: mutableListOf(mutableSetOf(node.`val`))
        
        return result
    }
    
    fun addValueToUnpairedNumberSets(unpairedNumberSets: MutableList<MutableSet<Int>>, value: Int): MutableList<MutableSet<Int>> {
        unpairedNumberSets.forEach { 
            if (value in it) {
                it.remove(value)
            } else {
                it.add(value)
            }
        }
        return unpairedNumberSets
    }
}
