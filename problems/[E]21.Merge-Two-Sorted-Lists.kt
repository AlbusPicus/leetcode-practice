/**
 * Runtime: 156 ms, faster than 91.13% of Kotlin online submissions for Merge Two Sorted Lists.
 * Memory Usage: 35 MB, less than 62.89% of Kotlin online submissions for Merge Two Sorted Lists.
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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstList = l1
        var secondList = l2
        
        val resultHead = ListNode(-1)
        var resultList = resultHead
        while (firstList != null && secondList != null) {
            val next: ListNode
            if (firstList.`val` > secondList.`val`) {
                next = secondList
                secondList = secondList.next
            } else {
                next = firstList
                firstList = firstList.next
            }
            resultList.next = next
            resultList = next
        }
        if (firstList != null) {
            resultList.next = firstList
        } else {
            resultList.next = secondList
        }
        return resultHead.next
    }
}
