/**
 * Runtime: 156 ms, faster than 87.34% of Kotlin online submissions for Reverse Linked List.
 * Memory Usage: 36.2 MB, less than 52.40% of Kotlin online submissions for Reverse Linked List.
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
        return head?.let { reverseListRec(it) }
    }
    
    fun reverseListRec(head: ListNode): ListNode {
        val next = head.next
        return if (next == null) {
            head
        } else {
            val node = reverseListRec(next)
            next?.next = head
            head.next = null
            node
        }
    }
}
