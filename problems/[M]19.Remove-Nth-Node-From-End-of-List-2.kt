/**
 * Runtime: 160 ms, faster than 76.89% of Kotlin online submissions for Remove Nth Node From End of List.
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
        val tempArray = Array<ListNode?>(n + 1) { null }
        var node = head
        var listSize = 0
        while (node != null) {
            tempArray[listSize % tempArray.size] = node
            
            node = node.next
            listSize++
        }
        
        return if (n < listSize) {
            val prevNode = tempArray[(listSize - 1 - n) % tempArray.size]
            prevNode?.next = prevNode?.next?.next
            head
        } else {
            head?.next
        }
    }
}
