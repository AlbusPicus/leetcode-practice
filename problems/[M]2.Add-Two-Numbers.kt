/**
 * Runtime: 204 ms, faster than 90.75% of Kotlin online submissions for Add Two Numbers.
 * Memory Usage: 41.3 MB, less than 70.23% of Kotlin online submissions for Add Two Numbers.
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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstNode = l1
        var secondNode = l2
        var resultHead = ListNode(-1)
        var result = resultHead
        var shouldAdd = false
        while (firstNode != null && secondNode != null) {
            val sum = firstNode.`val` + secondNode.`val` + if (shouldAdd) 1 else 0
            shouldAdd = sum > 9
            val newNode = ListNode(sum % 10)
            result.next = newNode
            result = newNode
            
            firstNode = firstNode.next
            secondNode = secondNode.next
        }
        var remainingDigitsNode = firstNode ?: secondNode
        while (remainingDigitsNode != null) {
            val sum = remainingDigitsNode.`val` + if (shouldAdd) 1 else 0
            shouldAdd = sum > 9
            val newNode = ListNode(sum % 10)
            result.next = newNode
            result = newNode
            
            remainingDigitsNode = remainingDigitsNode.next
        }
        if (shouldAdd) {
            result.next = ListNode(1)
        }
        return resultHead.next
    }
}
