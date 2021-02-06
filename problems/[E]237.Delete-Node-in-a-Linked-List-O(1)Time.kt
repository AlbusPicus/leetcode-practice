/**
 * Runtime: 148 ms, faster than 98.21% of Kotlin online submissions for Delete Node in a Linked List.
 * Memory Usage: 34.9 MB, less than 75.89% of Kotlin online submissions for Delete Node in a Linked List.
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

class Solution {
    fun deleteNode(node: ListNode?) {
        if (node != null && node.next != null) {
            node.`val` = node.next.`val`
            node.next = node.next.next
        }
    }
}
