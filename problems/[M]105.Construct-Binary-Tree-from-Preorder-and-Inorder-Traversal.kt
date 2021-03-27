/**
 * Runtime: 172 ms, faster than 96.70% of Kotlin online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 35.2 MB, less than 95.60% of Kotlin online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
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
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val inorderIndexMap = mutableMapOf<Int, Int>()
        for (i in 0 until inorder.size) {
            inorderIndexMap.put(inorder[i], i)
        }

        return buildTree(preorder, inorder, 0, preorder.size - 1, 0, inorderIndexMap).first
    }
    
    private fun buildTree(preorder: IntArray, inorder: IntArray, left: Int, right: Int, preorderIndex: Int, inorderIndexMap: Map<Int, Int>): Pair<TreeNode?, Int> {
        if (left > right) return null to 0

        val rootValue = preorder[preorderIndex]
        val root = TreeNode(rootValue)

        var preIncrement = 1
        val leftSubtreeEndIndex = inorderIndexMap[rootValue]!! - 1
        buildTree(preorder, inorder, left, leftSubtreeEndIndex, preorderIndex + preIncrement, inorderIndexMap)?.let {
            root.left = it.first
            preIncrement += it.second
        }
        val rightSubtreeStartIndex = inorderIndexMap[rootValue]!! + 1
        buildTree(preorder, inorder, rightSubtreeStartIndex, right, preorderIndex + preIncrement, inorderIndexMap)?.let {
            root.right = it.first
            preIncrement += it.second
        }
        return root to preIncrement
    }
    
}
