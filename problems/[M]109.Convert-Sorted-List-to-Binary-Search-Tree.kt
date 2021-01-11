/**
 * Runtime: 196 ms, faster than 88.37% of Kotlin online submissions for Convert Sorted List to Binary Search Tree.
 * Memory Usage: 38 MB, less than 44.19% of Kotlin online submissions for Convert Sorted List to Binary Search Tree.
 */
 
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
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
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var temp = head
        var list = mutableListOf<TreeNode>()
        while (temp != null) {
            list.add(TreeNode(temp.`val`))
            temp = temp.next
        }
        
        return getNode(list, 0, list.size - 1)
    }
    
    private fun getNode(items: List<TreeNode>, start: Int, end: Int): TreeNode? {
        if (end < start) {
            return null
        }
        
        val headIndex = start + (end - start) / 2
        val head = items[headIndex]
        head.left = getNode(items, start, headIndex - 1)
        head.right = getNode(items, headIndex + 1, end)
        
        return head
    }
}
