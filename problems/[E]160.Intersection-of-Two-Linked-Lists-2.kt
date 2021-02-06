/**
 * Runtime: 152 ms, faster than 87.31% of Kotlin online submissions for Intersection of Two Linked Lists.
 * Memory Usage: 38.3 MB, less than 63.43% of Kotlin online submissions for Intersection of Two Linked Lists.
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
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val nodesSet = mutableSetOf<ListNode>()
        var pointerA = headA
        var pointerB = headB
        var aChanged = false
        var bChanged = false
        while (pointerA != pointerB) {
            if (pointerA?.next == null && !aChanged) {
                aChanged = true
                pointerA = headB
            } else {
                pointerA = pointerA?.next
            }
            if (pointerB?.next == null && !bChanged) {
                bChanged = true
                pointerB = headA
            } else {
                pointerB = pointerB?.next
            }
        }
        
        return pointerA
    }
}
