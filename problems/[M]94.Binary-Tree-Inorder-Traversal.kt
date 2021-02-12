/**
 * Runtime: 148 ms, faster than 87.38% of Kotlin online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 33.9 MB, less than 80.37% of Kotlin online submissions for Binary Tree Inorder Traversal.
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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        root?.let { 
            fillInorderTraversal(it, result) 
        }
        return result
    }
    
    private fun fillInorderTraversal(node: TreeNode, resultList: MutableList<Int>) {
        node.left?.let { fillInorderTraversal(it, resultList) }
        resultList.add(node.`val`)
        node.right?.let { fillInorderTraversal(it, resultList) }
    }
}
