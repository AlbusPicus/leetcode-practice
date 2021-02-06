/**
 * Runtime: 184 ms, faster than 35.07% of Kotlin online submissions for Intersection of Two Linked Lists.
 * Memory Usage: 39.1 MB, less than 30.60% of Kotlin online submissions for Intersection of Two Linked Lists.
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
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        val nodesSet = mutableSetOf<ListNode>()
        var nodeA = headA
        var nodeB = headB
        while (nodeA != null || nodeB != null) {
            if (nodeA != null) {
                if (nodeA in nodesSet) {
                    return nodeA
                } else {
                    nodesSet.add(nodeA)
                    nodeA = nodeA.next
                }
            }
            if (nodeB != null) {
                if (nodeB in nodesSet) {
                    return nodeB
                } else {
                    nodesSet.add(nodeB)
                    nodeB = nodeB.next
                }
            }
        }
        
        return null
    }
}
