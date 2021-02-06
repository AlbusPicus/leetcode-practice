/**
 * Runtime: 168 ms, faster than 93.86% of Kotlin online submissions for Linked List Cycle.
 * Memory Usage: 36.3 MB, less than 49.88% of Kotlin online submissions for Linked List Cycle.
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
    fun hasCycle(head: ListNode?): Boolean {
        var slowNode = head
        var fastNode = head
        while (slowNode != null && fastNode != null) {
            slowNode = slowNode.next
            fastNode = fastNode.next?.next
            
            if (slowNode != null && slowNode == fastNode) return true
        }
        return false
    }
}
