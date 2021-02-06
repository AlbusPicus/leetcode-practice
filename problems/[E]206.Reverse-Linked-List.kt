/**
 * Runtime: 152 ms, faster than 95.19% of Kotlin online submissions for Reverse Linked List.
 * Memory Usage: 35.9 MB, less than 83.29% of Kotlin online submissions for Reverse Linked List.
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
    fun reverseList(head: ListNode?): ListNode? {
        var reversedHead: ListNode? = null
        var node = head
        while (node != null) {
            val next = node.next
            node.next = reversedHead
            reversedHead = node
            node = next
        }
        return reversedHead
    }
}
