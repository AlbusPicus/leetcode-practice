/**
 * Runtime: 156 ms, faster than 85.78% of Kotlin online submissions for Remove Nth Node From End of List.
 * Memory Usage: 34.9 MB, less than 61.33% of Kotlin online submissions for Remove Nth Node From End of List.
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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        val target = size - n
        return if (target == 0) {
            head?.next
        } else {
            var currentNodeOrder = 0
            node = head
            while (node != null) {
                currentNodeOrder++
                if (currentNodeOrder == target) {
                    node.next = node.next?.next
                    break
                }
                node = node.next
            }
            head
        }
        
    }
}
