/**
 * Runtime: 196 ms, faster than 70.37% of Kotlin online submissions for Binary Tree Level Order Traversal II.
 * Memory Usage: 35.9 MB, less than 75.93% of Kotlin online submissions for Binary Tree Level Order Traversal II.
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
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        return if (root == null) {
            emptyList()
        } else getLevelOrderTraversal(root)
    }
    
    private fun getLevelOrderTraversal(node: TreeNode): MutableList<MutableList<Int>> {
        val leftList = node.left?.let { getLevelOrderTraversal(it) }
        val rightList = node.right?.let { getLevelOrderTraversal(it) }
        
        val result = if (leftList != null && rightList != null) {
            combineLevels(leftList, rightList)
        } else leftList ?: rightList ?: mutableListOf<MutableList<Int>>()
        
        result.add(mutableListOf(node.`val`))
        return result
    }
    
    private fun combineLevels(left: MutableList<MutableList<Int>>, right: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val leftSize = left.size
        val rightSize = right.size
        val minSize = Math.min(leftSize, rightSize)
        for (i in 1 .. minSize) {
            left[leftSize - i].addAll(right[rightSize - i])
        }
        
        if (rightSize > leftSize) {
            left.addAll(0, right.subList(0, right.size - minSize))
        }
        return left
    }
}
