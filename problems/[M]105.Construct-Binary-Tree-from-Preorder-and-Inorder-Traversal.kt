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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderIndexMap = mutableMapOf<Int, Int>()
        for (i in 0 until inorder.size) {
            inorderIndexMap.put(inorder[i], i)
        }

        return buildTree(preorder, inorder, 0, preorder.size - 1, 0, inorderIndexMap)
    }
    
    private fun buildTree(preorder: IntArray, inorder: IntArray, left: Int, right: Int, preorderIndex: Int, inorderIndexMap: Map<Int, Int>): TreeNode? {
        var preIndex = preorderIndex
        if (left > right) return null

        val rootValue = preorder[preIndex]
        val root = TreeNode(rootValue)
        preIndex++
        
        val leftSubtreeEndIndex = inorderIndexMap[rootValue]!! - 1
        buildTree(preorder, inorder, left, leftSubtreeEndIndex, preIndex, inorderIndexMap)?.let {
            root.left = it
            preIndex++
        }
        
        val rightSubtreeStartIndex = inorderIndexMap[rootValue]!! + 1
        buildTree(preorder, inorder, rightSubtreeStartIndex, right, preIndex, inorderIndexMap)?.let {
            root.right = it
        }
        return root
    }
    
}
