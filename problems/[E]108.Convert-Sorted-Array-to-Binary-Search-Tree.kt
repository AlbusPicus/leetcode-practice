/**
 * Runtime: 172 ms, faster than 92.66% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
 * Memory Usage: 37 MB, less than 88.07% of Kotlin online submissions for Convert Sorted Array to Binary Search Tree.
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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return createSubTree(nums, 0, nums.size - 1)
    }
    
    private fun createSubTree(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {
        if (startIndex > endIndex) return null
        
        val mid = startIndex + (endIndex - startIndex) / 2
        val node = TreeNode(nums[mid])
        node.left = createSubTree(nums, startIndex, mid - 1)
        node.right = createSubTree(nums, mid + 1, endIndex)
        return node
    }
}
