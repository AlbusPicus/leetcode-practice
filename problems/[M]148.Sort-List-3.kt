/**
 * Runtime: 284 ms, faster than 93.75% of Kotlin online submissions for Sort List.
 * Memory Usage: 44.6 MB, less than 93.75% of Kotlin online submissions for Sort List.
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
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        
        var slow = head
        var fast = head?.next?.next
        var count = 0
        while (fast != null) {
            count++
            slow = slow?.next
            fast = fast?.next?.next
        }
        val secondHalf = slow?.next
        slow?.next = null
        var firstSorted = sortList(head)
        var secondSorted = sortList(secondHalf)
        
        val resultHead = if (firstSorted!!.`val` > secondSorted!!.`val`) {
            secondSorted.also { secondSorted = secondSorted!!.next }
        } else {
            firstSorted.also { firstSorted = firstSorted!!.next }
        }
        var resultNode = resultHead
        
        while (firstSorted != null && secondSorted != null) {
            val first = firstSorted!!
            val second = secondSorted!!
            if (first.`val` > second.`val`) {
                resultNode.next = second
                resultNode = second
                secondSorted = second.next
            } else {
                resultNode.next = first
                resultNode = first
                firstSorted = first.next
            }
            resultNode.next = null
        }
        if (firstSorted != null) {
            resultNode.next = firstSorted
        } else if (secondSorted != null) {
            resultNode.next = secondSorted
        }
        
        return resultHead
    }
    
    
}
