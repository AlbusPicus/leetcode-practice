/**
 * Runtime: 152 ms, faster than 99.11% of Kotlin online submissions for Symmetric Tree.
 * Memory Usage: 35.2 MB, less than 75.56% of Kotlin online submissions for Symmetric Tree.
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
    fun isSymmetric(root: TreeNode?): Boolean {
        var levelNodes = LinkedList<TreeNode?>()
        root?.let { 
            levelNodes.offerLast(it.left)
            levelNodes.offerLast(it.right)
        }
        while (levelNodes.isNotEmpty()) {
            if (levelNodes.size % 2 != 0) return false
            
            val nextLevelLeftSide = LinkedList<TreeNode?>()
            val nextLevelRightSide = LinkedList<TreeNode?>()
            for (i in 0 until levelNodes.size / 2) {
                val leftNode = levelNodes.pollFirst()
                val rightNode = levelNodes.pollLast()
                if (leftNode == null && rightNode == null) continue
                if (leftNode?.`val` != rightNode?.`val`) return false
                
                nextLevelLeftSide.offerLast(leftNode!!.left)
                nextLevelLeftSide.offerLast(leftNode.right)
                nextLevelRightSide.offerFirst(rightNode!!.right)
                nextLevelRightSide.offerFirst(rightNode.left)
            }
            nextLevelLeftSide.addAll(nextLevelRightSide)
            
            levelNodes = nextLevelLeftSide
        }
        return true
    }
}
