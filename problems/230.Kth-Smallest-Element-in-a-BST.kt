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
 
/**
 * Runtime: 192 ms, faster than 92.23% of Kotlin online submissions for Kth Smallest Element in a BST.
 * Memory Usage: 36.4 MB, less than 58.25% of Kotlin online submissions for Kth Smallest Element in a BST.
 */
class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val elementsCount = mutableMapOf<TreeNode, Int>()
        fillOutElementsCount(root, elementsCount)
        return if (root != null) {
            findKthSmallestElement(root, k, elementsCount)
        } else {
            -1
        }
    }
    
    fun fillOutElementsCount(root: TreeNode?, elementsCount: MutableMap<TreeNode, Int>): Int {
        var count = 0
        if (root != null) {
            count = fillOutElementsCount(root.left, elementsCount) + fillOutElementsCount(root.right, elementsCount) + 1
            elementsCount.put(root, count)
        }
        return count
    }

    fun findKthSmallestElement(root: TreeNode, k: Int, elementsCount: Map<TreeNode, Int>): Int {
        val leftNode = root.left
        val rightNode = root.right
        val leftChildsCount = if (leftNode != null) elementsCount.getOrElse(leftNode) { 0 } else 0
        val rightChildsCount = if (rightNode != null) elementsCount.getOrElse(rightNode) { 0 } else 0
        return if (leftNode != null && leftChildsCount >= k) {
            findKthSmallestElement(leftNode, k, elementsCount)
        } else if (leftChildsCount + 1 == k) {
            root.`val`
        } else {
            findKthSmallestElement(rightNode, k - leftChildsCount - 1, elementsCount)
        }
    }
}
