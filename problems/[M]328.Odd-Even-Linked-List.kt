/**
 * Runtime: 204 ms, faster than 17.46% of Kotlin online submissions for Odd Even Linked List.
 * Memory Usage: 36.3 MB, less than 22.22% of Kotlin online submissions for Odd Even Linked List.
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
    fun oddEvenList(head: ListNode?): ListNode? {
        val oddNodesHead = head
        var oddNode = oddNodesHead
        
        val evenNodeHead = head?.next
        var evenNode = evenNodeHead
        
        var currentNode = head?.next?.next
        
        oddNode?.next = null
        evenNode?.next = null
        
        var isOdd = true
        while (currentNode != null) {
            if (isOdd) {
                oddNode?.next = currentNode
                oddNode = currentNode
            } else {
                evenNode?.next = currentNode
                evenNode = currentNode
            }
            val temp = currentNode
            currentNode = currentNode.next
            temp.next = null
            isOdd = !isOdd
        }
        oddNode?.next = evenNodeHead
        
        return oddNodesHead
    }
}
