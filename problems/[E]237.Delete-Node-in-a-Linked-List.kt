/**
 * Runtime: 160 ms, faster than 88.39% of Kotlin online submissions for Delete Node in a Linked List.
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
        var listNode = node
        while (listNode != null && listNode.next != null && listNode.next.next != null) {
            listNode.`val` = listNode.next.`val`
            listNode = listNode.next
        }
        if (listNode != null && listNode.next != null) {
            listNode.`val` = listNode.next.`val`
            listNode.next = null
        }
    }
}
